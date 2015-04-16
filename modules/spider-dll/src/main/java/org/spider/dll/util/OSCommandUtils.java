/**
 * 
 */
package org.spider.dll.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.spider.base.OSPlatform;
import org.spider.base.util.OSinfoUtils;
import org.spider.base.util.SpiderClassLoader;
import org.spider.base.util.XMLToObjectUtil;
import org.spider.dll.OSCommand;
import org.spider.dll.model.DllBean;
import org.spider.dll.model.SpiderDllConfig;

/**
 * @author yangguangftlp
 * 
 * @date 2015年4月16日
 */
@SuppressWarnings("unchecked")
public class OSCommandUtils {

	private static OSCommandUtils instance;
	private static String spiderConfigPath = "config/spiderDllConfig.xml";
	private Map<String, Map<Class<?>, OSCommand>> osCommandMap = new HashMap<String, Map<Class<?>, OSCommand>>();
	private SpiderDllConfig spiderDllConfig;

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
		InputStream in = null;
		try {
			in = SpiderClassLoader.getInstance().getResourceAsStream(spiderConfigPath);
			spiderDllConfig = XMLToObjectUtil.getInstance().transform(in, SpiderDllConfig.class, true);
			if (null != spiderDllConfig && null != spiderDllConfig.getDllBeans()) {
				Iterator<DllBean> iterator = spiderDllConfig.getDllBeans().iterator();
				DllBean dllBean = null;
				OSPlatform osPlatform = OSinfoUtils.getOSname();
				while (iterator.hasNext()) {
					dllBean = iterator.next();
					if (osPlatform.name().equalsIgnoreCase(dllBean.getOsName())) {
						if (!osCommandMap.containsKey(osPlatform.name())) {
							osCommandMap.put(osPlatform.name(), new HashMap<Class<?>, OSCommand>());
						} else {

							OSCommand osCommand = (OSCommand) SpiderClassLoader.getInstance().newInstance(
									dllBean.getClassName());
							osCommandMap.get(osPlatform.name()).put(osCommand.getType(), osCommand);
						}
					}
				}
			}
		} catch (Exception e) {

		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 获取平台命令
	 * 
	 * @param cls
	 * @return
	 */
	public <T> T getCommand(Class<T> cls) {
		OSPlatform osPlatform = OSinfoUtils.getOSname();
		return (T) osCommandMap.get(osPlatform.name()).get(cls);
	}
}
