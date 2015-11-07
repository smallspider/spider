/**
 * 
 */
package org.spider.server.client;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.spider.server.client.impl.SpiderMessage;
import org.spider.server.util.ByteUtil;

/**
 * @author yangguangftlp
 * 
 *         2015年4月2日
 */
public class SpiderMessageFactory {

	private static SpiderMessageFactory instance;

	public static SpiderMessageFactory getInstance() {
		if (null == instance) {
			synchronized (SpiderMessageFactory.class) {
				if (null == instance) {
					instance = new SpiderMessageFactory();
				}
			}
		}
		return instance;
	}

	public SpiderMessage createSpiderMessage(InputStream in) {
		try {
			int total = 0;
			while (total == 0) {
				total = in.available();
			}
			byte[] bytes = new byte[total];
			in.read(bytes);
			SpiderMessage spiderMessage = new SpiderMessage();
			spiderMessage.setVersion(new String(Arrays.copyOfRange(bytes, 0, 3)));
			spiderMessage.setCommandType(Arrays.copyOfRange(bytes, 3, 4)[0]);
			spiderMessage.setData(Arrays.copyOfRange(bytes, 4, total));
			return spiderMessage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 下标从0开始计算
	 * 
	 * @param index
	 * @param length
	 * @return
	 */
	public byte[] getData(byte[] data, int index, int length) {
		if (null != data) {
			int l = data.length;
			if ((index > -1 && index < l) && (length <= (l - index))) {
				byte[] b = new byte[length];
				for (int i = 0; index < length; index++, i++) {
					b[i] = data[index];
				}
				return b;
			}
		}
		Arrays.copyOfRange(data, 0, 3);
		return new byte[0];
	}

	public static void main(String[] args) {
		System.out.println(Charset.defaultCharset().name());
	}
}
