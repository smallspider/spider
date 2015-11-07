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
package org.spider.ui.widget;

import java.util.HashMap;
import java.util.Map;

import org.spider.ui.ScreenWindow;

/**
 * @author yangguangftlp
 * 
 */
public class WidgetManager {
	private static WidgetManager instance;
	private Map<String, Widget> widgetMap;

	private WidgetManager() {
		widgetMap = new HashMap<String, Widget>();
		init();
	}

	/**
	 * 初始化默认组件
	 */
	private void init() {
		widgetMap.put("ScreenWindow.class", new ScreenWindow());
	}

	public static WidgetManager getInstance() {
		if (null == instance) {
			synchronized (WidgetManager.class) {
				if (null == instance) {
					instance = new WidgetManager();
				}
			}
		}
		return instance;
	}

	public Widget getWidget(String id) {
		return (Widget) widgetMap.get(id);
	}

	public void addMonitorPanel(Widget widget) {
		widgetMap.put(widget.getWid(), widget);
	}

	public Object removeMonitorPanel(String id) {
		return widgetMap.remove(id);
	}
}
