/**
 * dll 命令
 * 
 */
package org.spider.dll.command;

import org.spider.dll.OSCommand;

/**
 * 
 * windows平台操作
 * 
 * @author yangguang
 * 
 */
public class WindowsCommand implements OSCommand {

	/**
	 * 获取桌面视图像素根据像素可以生成一副桌面视图图像
	 * 
	 * @param iBitCount
	 *            位图每像素的bit数
	 * @return 返回像素
	 */
	public native byte[] getScreenpixels(int iBitCount);

	/**
	 * 安装钩子函数
	 * 
	 * @return 返回安装是状态
	 */
	public native boolean installHook();

	/**
	 * 卸载钩子
	 * 
	 * @return 返回卸载钩子状态
	 */
	public native boolean unInstallHook();

	public Class<?> getType() {
		return WindowsCommand.class;
	}
}
