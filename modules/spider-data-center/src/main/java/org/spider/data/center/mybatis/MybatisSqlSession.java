/**
 * Copyright 1996-2014 FoxBPM ORG.
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
 * @author ych
 */
package org.spider.data.center.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spider.data.center.sqlsession.ISqlSession;

public class MybatisSqlSession implements ISqlSession {

	private SqlSession sqlSession;
	public static Logger log = LoggerFactory.getLogger(MybatisSqlSession.class);

	public MybatisSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	

	public List<?> selectList(String statement) {
		return sqlSession.selectList(statement);
	}

	public List<?> selectList(String statement, Object parameter) {
		return sqlSession.selectList(statement, parameter);
	}

	public Object selectOne(String statement, Object parameter) {
		Object result = sqlSession.selectOne(statement, parameter);
		return result;
	}

	public void commit() {
		
	}

	public void rollback() {
		if (this.sqlSession != null) {
			this.sqlSession.rollback();
		}
	}

	public void close() {
		if (this.sqlSession != null) {
			this.sqlSession.close();
		}
	}

	/* (non-Javadoc)
	 * @see org.spider.data.center.sqlsession.ISqlSession#insert(java.lang.String, java.lang.Object)
	 */
	public <T> Integer insert(String insertStatement, T obj) {
		// TODO Auto-generated method stub
		return sqlSession.insert(insertStatement, obj);
	}

	/* (non-Javadoc)
	 * @see org.spider.data.center.sqlsession.ISqlSession#update(java.lang.String, java.lang.Object)
	 */
	public <T> Integer update(String updateStatement, T obj) {
		// TODO Auto-generated method stub
		return sqlSession.update(updateStatement, obj);
	}

	/* (non-Javadoc)
	 * @see org.spider.data.center.sqlsession.ISqlSession#delete(java.lang.String, java.lang.Object)
	 */
	public <T> Integer delete(String deleteStatement, T obj) {
		// TODO Auto-generated method stub
		return sqlSession.delete(deleteStatement, obj);
	}

	/* (non-Javadoc)
	 * @see org.spider.data.center.sqlsession.ISqlSession#queryOne(java.lang.String, java.lang.Object)
	 */
	public <T> T queryOne(String queryStatement, T obj) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(queryStatement, obj);
	}

	/* (non-Javadoc)
	 * @see org.spider.data.center.sqlsession.ISqlSession#query(java.lang.String, java.lang.Object)
	 */
	public <T> List<T> query(String queryStatement, T obj) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(queryStatement, obj);
	}
}
