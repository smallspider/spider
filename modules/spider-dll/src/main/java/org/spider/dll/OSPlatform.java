/**
 * 
 */
package org.spider.dll;

/**
 * @author yangguangftlp
 * 
 * @date 2015年4月16日
 */
public enum OSPlatform {
	Any("any"), Linux("Linux"), Mac_OS("Mac OS"), Mac_OS_X("Mac OS X"), Windows("Windows"), OS2("OS/2"), Solaris(
			"Solaris"), SunOS("SunOS"), MPEiX("MPE/iX"), HP_UX("HP-UX"), AIX("AIX"), OS390("OS/390"), FreeBSD("FreeBSD"), Irix(
			"Irix"), Digital_Unix("Digital Unix"), NetWare_411("NetWare"), OSF1("OSF1"), OpenVMS("OpenVMS"), Others(
			"Others");

	private String description;

	private OSPlatform(String desc) {
		this.description = desc;
	}

	public String toString() {
		return description;
	}

}
