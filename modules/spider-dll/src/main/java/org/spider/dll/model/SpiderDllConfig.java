/**
 * 
 */
package org.spider.dll.model;

import java.util.List;

import org.spider.base.annotation.ElementSign;

/**
 * @author yangguangftlp
 * 
 * @date 2015年4月16日
 */
public class SpiderDllConfig {

	private List<DllBean> dllBeans;
	private List<DllResource> dllResources;

	public List<DllBean> getDllBeans() {
		return dllBeans;
	}

	@ElementSign(xmlEleName = "dllBean", beanType = DllBean.class)
	public void setDllBeans(List<DllBean> dllBeans) {
		this.dllBeans = dllBeans;
	}

	public List<DllResource> getDllResources() {
		return dllResources;
	}

	@ElementSign(xmlEleName = "dllResource", beanType = DllResource.class)
	public void setDllResources(List<DllResource> dllResources) {
		this.dllResources = dllResources;
	}

}
