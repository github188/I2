/**
 * Project: I2
 * 
 * File Created at 2012-11-28
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
package com.bullx.ui;

/**
 * TODO Comment of TestJScrollPane
 * @author Administrator
 */
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TestJScrollPane extends JFrame {

    private static final long serialVersionUID = 1L;

    public TestJScrollPane() {
        super("I2Service");
        this.setLayout(null);
        this.setBounds(20, 20, 200, 300);
        
        JLabel label = new JLabel("深入浅出Java Swing 程序设计");

        JPanel panel = new JPanel();
        panel.add(label);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(100, 100, 100, 300);
        /**
         * 要加滚动条就要让panel的宽高大于scrollPane的宽高..你只要上下的..只要高大于就行了..
         */
        panel.setPreferredSize(new Dimension(scrollPane.getWidth() - 50, scrollPane.getHeight() * 2));
        this.add(scrollPane);
        panel.revalidate(); //告诉其他部件,我的宽高变了
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestJScrollPane();
    }
}
