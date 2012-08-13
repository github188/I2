/**
 * Project: I2
 * 
 * File Created at 2012-8-11
 * $Id$
 * 
 * Copyright 1999-2100 Bullx.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Bullx Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Bullx.com.
 */
package com.bullx.demo.xml;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.bullx.constants.Log;

/**
 * XMLParser Demo
 * 
 * @author Administrator
 */
public class XMLParser {

    public static void bookListToXML(List<Book> books) {
        Document document = DocumentHelper.createDocument();
        // 建立XML文档的根books
        Element booksElement = document.addElement("books");
        // 加入一行注释 
        booksElement.addComment("This is a test for dom4j, liubida, 2012.8.11");

        for (Book book : books) {
            // 增加一个节点
            Element bookElement = booksElement.addElement("book");
            // 设置属性: show
            bookElement.addAttribute("show", book.getShow() ? "yes" : "no");
            // 加入title节点
            bookElement.addElement("title").setText(book.getTitle());
            // 加入express节点
            bookElement.addElement("express").setText(book.getExpress());
        }

        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        StringWriter out = new StringWriter();
        XMLWriter xmlWriter = new XMLWriter(out, format);
        try {
            xmlWriter.write(document);
            xmlWriter.flush();
            String s = out.toString();
            System.out.println(s);
            Log.info("xml done!");
        } catch (Exception e) {
            Log.warn("xml error!");
        } finally {
            try {
                if (null != xmlWriter) {
                    xmlWriter.close();
                }
                if (null != out) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("黑客与画家", "人民邮电出版社", true));
        books.add(new Book("编码", "电子工业出版社", true));
        books.add(new Book("激荡三十年", "中信出版社", false));
        bookListToXML(books);
    }
}

class Book {
    private String  title;
    private Boolean show;
    private String  express;

    Book(String title, String express, Boolean show) {
        this.title = title;
        this.express = express;
        this.show = show;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the express
     */
    public String getExpress() {
        return express;
    }

    /**
     * @param express the express to set
     */
    public void setExpress(String express) {
        this.express = express;
    }

    /**
     * @return the show
     */
    public Boolean getShow() {
        return show;
    }

    /**
     * @param show the show to set
     */
    public void setShow(Boolean show) {
        this.show = show;
    }
}
