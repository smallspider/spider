package org.spider.ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FullScreenTest {
    public static void main(String[] args) {
        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        FullScreenWindow myWindow = new FullScreenWindow();
        if (gd.isFullScreenSupported()) {
            gd.setFullScreenWindow(myWindow);
        } else {
            System.out.println("Unsupported full screen.");
        }
    }
}

class FullScreenWindow extends JWindow {
    public FullScreenWindow() {
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                quit();
            }
        });
    }

    public void quit() {
        this.dispose();
    }

    public void paint(Graphics g) {
        g.setFont(new Font("宋体", Font.BOLD, 30));
        g.setColor(Color.RED);
        g.drawString("这是全屏幕模式", 100, 100);
    }
}

