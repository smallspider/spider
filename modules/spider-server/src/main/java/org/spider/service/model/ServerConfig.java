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
package org.spider.service.model;

import org.spider.service.annotation.ElementSign;

/**
 * @author yangguangftlp
 * @date 2015年1月17日
 */
public class ServerConfig {
	/** 是否暂停 */
	private boolean isStop;
	/** 是否继续 */
	private boolean isSuspend;
	/** 服务状态 */
	private int status;
	/** 默认时间 */
	private int threadSleep = 100;

	public int getStatus() {
		return status;
	}

	public int getThreadSleep() {
		return threadSleep;
	}

	public boolean isStop() {
		return isStop;
	}

	public boolean isSuspend() {
		return isSuspend;
	}

	@ElementSign(xmlEleName = "status", beanType = Integer.class)
	public void setStatus(int status) {
		this.status = status;
	}

	@ElementSign(xmlEleName = "isStop", beanType = Boolean.class)
	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}

	@ElementSign(xmlEleName = "isSuspend", beanType = Boolean.class)
	public void setSuspend(boolean isSuspend) {
		this.isSuspend = isSuspend;
	}

	@ElementSign(xmlEleName = "threadSleep", beanType = Integer.class)
	public void setThreadSleep(int threadSleep) {
		this.threadSleep = threadSleep;
	}

}
