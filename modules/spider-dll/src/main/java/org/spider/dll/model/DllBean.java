/**
 * 
 */
package org.spider.dll.model;

import org.spider.base.annotation.ElementSign;

/**
 * @author yangguangftlp
 * 
 * @date 2015年4月16日
 */
public class DllBean {

	private String id;
	private String name;
	private String className;
	private String osName;

	private DllResource dllResource;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public DllResource getDllResource() {
		return dllResource;
	}

	@ElementSign(xmlEleName = "dllResource", beanType = DllResource.class)
	public void setDllResource(DllResource dllResource) {
		this.dllResource = dllResource;
	}
}
