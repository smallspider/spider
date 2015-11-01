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
    	init();
    	MainUI mainUI = new MainUI();
		mainUI.setUndecorated(false);
		mainUI.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//screenSize.setSize(screenSize.getWidth(), screenSize.getHeight()-50);
		Rectangle bounds = new Rectangle(screenSize);
		mainUI.setBounds(bounds);
		mainUI.
		setMinimumSize(screenSize);
		mainUI.setExtendedState(MainUI.MAXIMIZED_BOTH);
		mainUI.setDefaultCloseOperation(MainUI.EXIT_ON_CLOSE);
		mainUI.setVisible(true);
		mainUI.setAlwaysOnTop(true);
    }

	private static void init() {
		//加载皮肤
		try {
			//UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
    	} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
