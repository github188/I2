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

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * TODO Comment of FlowDemo
 * 
 * @author Administrator
 */
public class FlowDemo {

    public static void main(String[] args) {
        JFrame f = new JFrame("FlowLayout");
        f.setLayout(new FlowLayout());
        for (int i = 0; i < 7; i++) {
            JButton btn = new JButton("Button" + i);
            f.add(btn);
        }
        f.setSize(300, 150);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
