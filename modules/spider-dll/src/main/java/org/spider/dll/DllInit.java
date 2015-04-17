/**
 * Copyright 2014 smallspider ORG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author yangguangftlp
 */
package org.spider.dll;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.spider.base.util.OSinfoUtils;

/**
 * @author yangguangftlp
 * @date 2015年4月12日
 */
public class DllInit {

	static {
		
	}
	public static void main(String[] args) {
		init();
	}

	public static void init() {
		String libFileName = null;
		String resourcePath = null;
		String resourceName = null;
		if (OSinfoUtils.isWindows()) {
			resourcePath = "dll\\windows";
			resourceName = "WindowsCommand.dll";
		}

		if (StringUtils.isEmpty(libFileName)) {
			InputStream input = null;
			OutputStream output = null;
			try {
				StringBuffer java_io_tmpdir = new StringBuffer(System.getProperty("java.io.tmpdir"));
				java_io_tmpdir.append('\\').append(resourcePath);
				File tmpFile = new File(java_io_tmpdir.toString());
				if (!tmpFile.exists()) {
					tmpFile.mkdirs();
				}
				URL url = ThreadLocal.class.getClassLoader().getResource(resourcePath + File.separator + resourceName);
				output = new FileOutputStream(java_io_tmpdir.append('\\').append(resourceName).toString());
				IOUtils.copy(url.openStream(), output);
				System.out.println("加载dll路径：" + java_io_tmpdir);
				System.load(java_io_tmpdir.toString());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				IOUtils.closeQuietly(input);
				IOUtils.closeQuietly(output);

			}
		}
	}
}
