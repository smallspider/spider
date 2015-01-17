package org.spider.server.util;

import java.util.LinkedList;
import java.util.Queue;

import org.spider.data.model.DataPacket;

/**
 * 数据包队列
 * 
 * @author yangguangftlp
 * 
 *         2015年1月6日
 */
public class DataPacketUtil {
	private static DataPacketUtil instance;
	private Queue<DataPacket> queueDataPacket = new LinkedList<DataPacket>();

	public static DataPacketUtil getInstance() {
		if (null == instance) {
			synchronized (DataPacketUtil.class) {
				if (null == instance) {
					instance = new DataPacketUtil();
				}
			}
		}
		return instance;
	}

	public synchronized DataPacket get() {
		try {
			while (queueDataPacket.isEmpty()) {
				this.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return queueDataPacket.poll();
	}

	public synchronized void add(DataPacket dataPacket) {
		queueDataPacket.add(dataPacket);
		this.notify();
	}
}
