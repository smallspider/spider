/**
 * 
 */
package org.spider.data.center.service;

import java.util.List;

import org.spider.data.center.persistence.DBEntity;

/**
 * @author yangguangftlp
 * 
 * @date 2015年4月6日
 */
public interface DaoService {
	void insert(DBEntity entity);

	List<?> query(DBEntity entity);

	boolean update(DBEntity entity);

	int count(DBEntity entity);
}
