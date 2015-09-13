/**
 * 
 */
package org.spider.base.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author tf
 * 
 */
public final class StreamUtil {

	public static void colse(InputStream input) {
		if (null != input) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void colse(OutputStream ouput) {
		if (null != ouput) {
			try {
				ouput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
