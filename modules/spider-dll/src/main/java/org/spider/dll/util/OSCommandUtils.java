/**
 * 
 */
package org.spider.dll.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.spider.base.OSPlatform;
import org.spider.base.util.OSinfoUtils;
import org.spider.base.util.SpiderClassLoader;
import org.spider.base.util.XMLToObjectUtil;
import org.spider.dll.OSCommand;
import org.spider.dll.model.DllBean;
import org.spider.dll.model.DllResource;
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
	private Map<String, List<String>> osDllResourceMap = new HashMap<String, List<String>>();
	private SpiderDllConfig spiderDllConfig;

	private OSCommandUtils() {
		init();
	}

	public static OSCommandUtils getInstance() {
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

			OSPlatform osPlatform = OSinfoUtils.getOSname();
			osDllResourceMap.put(osPlatform.name(), new ArrayList<String>());
			osCommandMap.put(osPlatform.name(), new HashMap<Class<?>, OSCommand>());

			in = SpiderClassLoader.getInstance().getResourceAsStream(spiderConfigPath);
			spiderDllConfig = XMLToObjectUtil.getInstance().transform(in, SpiderDllConfig.class, true);
			if (null != spiderDllConfig && null != spiderDllConfig.getDllBeans()) {
				Iterator<DllBean> iterator = spiderDllConfig.getDllBeans().iterator();
				DllBean dllBean = null;
				while (iterator.hasNext()) {
					dllBean = iterator.next();
					if (osPlatform.name().equalsIgnoreCase(dllBean.getOsName())) {
						OSCommand osCommand = (OSCommand) SpiderClassLoader.getInstance().newInstance(
								dllBean.getClassName());
						osCommandMap.get(osPlatform.name()).put(osCommand.getType(), osCommand);
						if (null != dllBean.getDllResource()) {
							loadDllResource(dllBean.getDllResource());
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

	private void loadDllResource(DllResource dllResource) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = SpiderClassLoader.getInstance().getResourceAsStream(dllResource.getPath());
			String tempDir = System.getProperty("java.io.tmpdir");
			String path = tempDir + File.separator + dllResource.getPath() + File.separator + dllResource.getFileName();
			File file = new File(path);
			if (file.exists()) {
				System.load(path);
			} else {
				// 将jar包中的dll资源,在默认的临时文件路径下重新生成dll文件
				File fileDir = new File(tempDir, dllResource.getPath());
				if (!fileDir.exists()) {
					fileDir.mkdirs();
				}
				out = new FileOutputStream(path);
				byte[] bytes = new byte[1024];
				while (in.read(bytes) != -1) {
					out.write(bytes);
				}
				out.flush();
				out.close();
				// 加载
				System.load(path);
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
			if (null != out) {
				try {
					out.close();
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
