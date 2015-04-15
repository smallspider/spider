/**
 * 
 */
package org.spider.server.db;

import java.util.List;

/**
 * @author yangguangftlp
 * 
 * @date 2015年4月15日
 */
public interface SqlCommand {

	<T> Integer insert(T obj);

	<T> Integer update(T obj);

	<T> Integer delete(T obj);

	<T> List<T> query(T obj);

	<T> List<T> query(T obj, int begin, int size);

	<T> Integer count(T obj);
}
