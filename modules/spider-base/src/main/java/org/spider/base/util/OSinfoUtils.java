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
package org.spider.base.util;

import org.spider.base.OSPlatform;

/**
 * @author yangguangftlp
 * @date 2015年4月12日
 */
public class OSinfoUtils {
	private static String OS = System.getProperty("os.name").toLowerCase();
	private static OSinfoUtils _instance = new OSinfoUtils();
	private OSPlatform osPlatform;

	private OSinfoUtils() {
		if (isAix()) {
			osPlatform = OSPlatform.AIX;
		} else if (isDigitalUnix()) {
			osPlatform = OSPlatform.Digital_Unix;
		} else if (isFreeBSD()) {
			osPlatform = OSPlatform.FreeBSD;
		} else if (isHPUX()) {
			osPlatform = OSPlatform.HP_UX;
		} else if (isIrix()) {
			osPlatform = OSPlatform.Irix;
		} else if (isLinux()) {
			osPlatform = OSPlatform.Linux;
		} else if (isMacOS()) {
			osPlatform = OSPlatform.Mac_OS;
		} else if (isMacOSX()) {
			osPlatform = OSPlatform.Mac_OS_X;
		} else if (isMPEiX()) {
			osPlatform = OSPlatform.MPEiX;
		} else if (isNetWare()) {
			osPlatform = OSPlatform.NetWare_411;
		} else if (isOpenVMS()) {
			osPlatform = OSPlatform.OpenVMS;
		} else if (isOS2()) {
			osPlatform = OSPlatform.OS2;
		} else if (isOS390()) {
			osPlatform = OSPlatform.OS390;
		} else if (isOSF1()) {
			osPlatform = OSPlatform.OSF1;
		} else if (isSolaris()) {
			osPlatform = OSPlatform.Solaris;
		} else if (isSunOS()) {
			osPlatform = OSPlatform.SunOS;
		} else if (isWindows()) {
			osPlatform = OSPlatform.Windows;
		} else {
			osPlatform = OSPlatform.Others;
		}
	}

	public static boolean isLinux() {
		return OS.indexOf("linux") >= 0;
	}

	public static boolean isMacOS() {
		return OS.indexOf("mac") >= 0 && OS.indexOf("os") > 0 && OS.indexOf("x") < 0;
	}

	public static boolean isMacOSX() {
		return OS.indexOf("mac") >= 0 && OS.indexOf("os") > 0 && OS.indexOf("x") > 0;
	}

	public static boolean isWindows() {
		return OS.indexOf("windows") >= 0;
	}

	public static boolean isOS2() {
		return OS.indexOf("os/2") >= 0;
	}

	public static boolean isSolaris() {
		return OS.indexOf("solaris") >= 0;
	}

	public static boolean isSunOS() {
		return OS.indexOf("sunos") >= 0;
	}

	public static boolean isMPEiX() {
		return OS.indexOf("mpe/ix") >= 0;
	}

	public static boolean isHPUX() {
		return OS.indexOf("hp-ux") >= 0;
	}

	public static boolean isAix() {
		return OS.indexOf("aix") >= 0;
	}

	public static boolean isOS390() {
		return OS.indexOf("os/390") >= 0;
	}

	public static boolean isFreeBSD() {
		return OS.indexOf("freebsd") >= 0;
	}

	public static boolean isIrix() {
		return OS.indexOf("irix") >= 0;
	}

	public static boolean isDigitalUnix() {
		return OS.indexOf("digital") >= 0 && OS.indexOf("unix") > 0;
	}

	public static boolean isNetWare() {
		return OS.indexOf("netware") >= 0;
	}

	public static boolean isOSF1() {
		return OS.indexOf("osf1") >= 0;
	}

	public static boolean isOpenVMS() {
		return OS.indexOf("openvms") >= 0;
	}

	/**
	 * 获取操作系统名字
	 * 
	 * @return 操作系统名
	 */
	public static OSPlatform getOSname() {
		return _instance.osPlatform;
	}
}