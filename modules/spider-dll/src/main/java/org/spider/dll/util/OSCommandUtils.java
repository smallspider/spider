/**
 * 
 */
package org.spider.dll.util;

import java.util.HashMap;
import java.util.Map;

import org.spider.dll.OSCommand;
import org.spider.dll.command.WindowsCommand;

/**
 * @author yangguangftlp
 * 
 * @date 2015年4月16日
 */
@SuppressWarnings("unchecked")
public class OSCommandUtils {

	private static OSCommandUtils instance;
	private Map<Class<?>, OSCommand> osCommandMap = new HashMap<Class<?>, OSCommand>();

	private OSCommandUtils() {
		init();
	}

	public OSCommandUtils getInstance() {
		if (null == instance) {
			synchronized (OSCommandUtils.class) {
				if (null == instance) {
					instance = new OSCommandUtils();
				}
			}
		}
		return instance;
	}

	private void init() {
		osCommandMap.put(WindowsCommand.class, new WindowsCommand());
	}

	/**
	 * 获取平台命令
	 * 
	 * @param cls
	 * @return
	 */
	public <T> T getCommand(Class<T> cls) {
		return (T) osCommandMap.get(cls);
	}
}
