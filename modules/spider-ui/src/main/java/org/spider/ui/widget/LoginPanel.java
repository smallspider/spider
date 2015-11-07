/**
 * 
 */
package org.spider.ui.widget;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.spider.resource.factory.LoadResource;
import org.spider.ui.LoginUI;

/**
 * @author yangguang
 * 
 */
public class LoginPanel extends JPanel {

	private JLabel jlabelName;
	private JLabel jlabelPassword;
	private JLabel jlabelZhuceUser;
	private JLabel jlabelFindPassWord;
	private JTextField jtextName;
	private JPasswordField jtextPassword;
	private JComboBox jcomboBox;
	private JButton jblogin;
	private JButton jbcancel;
	private LoginUI loginUI;

	public LoginPanel(LoginUI loginUI) {
		this.loginUI = loginUI;
		init();
	}

	void init() {
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		jlabelName = new JLabel("账    号 :");
		jlabelName.setBounds(new Rectangle(70, 70, 60, 20));

		jcomboBox = new JComboBox();
		jcomboBox.setEditable(true);
		jcomboBox.setBounds(new Rectangle(130, 65, 150, 30));

		jlabelZhuceUser = new JLabel("注册用户");
		jlabelZhuceUser.setBounds(new Rectangle(290, 70, 60, 20));

		add(jlabelName);
		add(jcomboBox);
		add(jlabelZhuceUser);

		jlabelPassword = new JLabel("密    码:");
		jlabelPassword.setBounds(new Rectangle(70, 120, 60, 20));

		jtextPassword = new JPasswordField(12);
		jtextPassword.setEchoChar('*');
		jtextPassword.setBounds(new Rectangle(130, 115, 150, 30));

		jlabelFindPassWord = new JLabel("找回密码");
		jlabelFindPassWord.setBounds(new Rectangle(290, 120, 60, 20));

		add(jlabelPassword);
		add(jtextPassword);
		add(jlabelFindPassWord);

		jblogin = new JButton("登陆");
		jblogin.setBounds(200, 180, 70, 30);
		jblogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				loginUI.setVisible(false);
				loginUI.showLoginProgressUI("", "");
			}
		});
		add(jblogin);
		jbcancel = new JButton("取消 ");
		jbcancel.setBounds(300, 180, 70, 30);
		jbcancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jbcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(jbcancel);
	}

}
