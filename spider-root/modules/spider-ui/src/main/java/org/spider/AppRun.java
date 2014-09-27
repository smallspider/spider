package org.spider;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import org.spider.ui.MainUI;

/**
 * Hello world!
 *
 */
public class AppRun
{
    public static void main( String[] args )
    {
    	MainUI mainUI = new MainUI();
		mainUI.setUndecorated(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle bounds = new Rectangle(screenSize);
		mainUI.setBounds(bounds);
		mainUI.setExtendedState(MainUI.MAXIMIZED_BOTH);
		mainUI.setDefaultCloseOperation(MainUI.EXIT_ON_CLOSE);
		mainUI.setVisible(true);
    }
}
