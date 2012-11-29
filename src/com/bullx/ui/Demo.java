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

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.bullx.client.ClientCall;

/**
 * @author Administrator
 */
public class Demo {
    private static String labelPrefix = "Number of button clicks: ";
    private final String BUTTON_LABEL = "启动Service";
    private int numClicks = 0; //计数器，计算点击次数

    public Component createComponents() {
        final JLabel label = new JLabel(BUTTON_LABEL + ": ");

        JButton button = new JButton(BUTTON_LABEL);
        button.setMnemonic(KeyEvent.VK_I); //设置按钮的热键为'I'
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numClicks++;
                label.setText(labelPrefix + numClicks);
                //显示按钮被点击的次数
            }
        });
        label.setLabelFor(button);

        /* 在顶层容器及其内容之间放置空间的常用办法是把内容添加到Jpanel上，而Jpanel本身没有边框的。 */

        JPanel pane = new JPanel();
        pane.setSize(200, 300);
        //        pane.setBounds(30, 30, 300, 30);
        //        pane.setLayout(new GridLayout(0, 1)); //单列多行
        pane.add(button);
        pane.add(label);
        return pane;
    }

    private final int WIDTH = 800;
    private final int HEIGHT = 494;
    private final String START = "启动Service:";
    private final String STOP = "停止Service:";
    private BlockingQueue<String> buffer = new LinkedBlockingQueue<String>();

    public Demo() {
        final ClientCall c = new ClientCall(buffer);

        JFrame f = new JFrame("FlowLayout");
        f.setLayout(new FlowLayout(FlowLayout.LEFT));

        final JButton btn = new JButton(START);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (START.equalsIgnoreCase(btn.getText())) {
                    new Thread(c).start();
                    btn.setText(STOP);
                    return;
                }
                if (STOP.equalsIgnoreCase(btn.getText())) {
                    c.cancel();
                    btn.setText(START);
                    return;
                }
            }
        });

        JTextArea txtArea = new JTextArea(28, 60);
        new Thread(new Consumer(buffer, txtArea)).start();
        f.add(btn);
        f.add(txtArea);
        f.setSize(WIDTH, HEIGHT);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Demo();
    }
}

class Consumer implements Runnable {
    private BlockingQueue<String> buffer = null;
    private JTextArea txtArea = null;
    private boolean bStop = true;

    public Consumer(BlockingQueue<String> buffer, JTextArea txtArea) {
        this.buffer = buffer;
        this.txtArea = txtArea;
    }

    public void run() {
        try {
            bStop = false;
            while (!Thread.interrupted() && !bStop) {
                txtArea.append(buffer.take());
            }
        } catch (InterruptedException e) {
            txtArea.append(e.getMessage());
        }
    }

    public boolean getStatus() {
        return !bStop;
    }

    public boolean cancel() {
        return bStop = true;
    }
}
