/**
 * 
 */
package org.spider.data.center.sqlsession;

import java.util.List;

/**
 * @author yangguangftlp
 * 
 * @date 2015年4月15日
 */
public interface ISqlSession {
	<T> Integer insert(String insertStatement, T obj);

	<T> Integer update(String updateStatement, T obj);

	<T> Integer delete(String deleteStatement, T obj);

	<T> T queryOne(String queryStatement, T obj);

	<T> List<T> query(String queryStatement, T obj);
}
