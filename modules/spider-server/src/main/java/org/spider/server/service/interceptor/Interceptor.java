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
package org.spider.server.service.interceptor;

/**
 * @author yangguangftlp
 * 
 */
public interface Interceptor {

	/**
	 * 返回下一个拦截器
	 * 
	 * @return
	 */
	public Interceptor next();

	/**
	 * 拦截器执行
	 */
	public void execute(Object obj);

}
