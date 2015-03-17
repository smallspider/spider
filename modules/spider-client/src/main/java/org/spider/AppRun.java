package org.spider;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.UIManager;

import org.spider.ui.MainUI;

/**
 * 应用启动
 *
 */
public class AppRun
{
    public static void main( String[] args )
    {
    	//init();
    	MainUI mainUI = new MainUI();
		mainUI.setUndecorated(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle bounds = new Rectangle(screenSize);
		mainUI.setBounds(bounds);
		mainUI.setExtendedState(MainUI.MAXIMIZED_BOTH);
		mainUI.setDefaultCloseOperation(MainUI.EXIT_ON_CLOSE);
		mainUI.setVisible(true);
    }

	private static void init() {
		//加载皮肤
		try {
			UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
    	} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
