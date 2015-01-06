package org.spider.server.model;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 数据包队列
 * 
 * @author yangguangftlp
 * 
 *         2015年1月6日
 */
public class DataPacketQueue {
	private static DataPacketQueue instance;
	private Queue<DataPacket> queueDataPacket = new LinkedList<DataPacket>();

	public static DataPacketQueue getInstance() {
		if (null == instance) {
			synchronized (DataPacketQueue.class) {
				if (null == instance) {
					instance = new DataPacketQueue();
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
