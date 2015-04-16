package org.spider.base.util;

import java.util.UUID;

public class GuidUtil {

	/**
	 * @return 返回唯一编号
	 */
	public static String CreateGuid() {
		// 创建GUID 以后可以替换为其他方法
		return UUID.randomUUID().toString();
	}

}
