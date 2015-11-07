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
package org.spider.data.center.sqlsession;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spider.data.center.mybatis.MybatisSqlSession;

public class MyBatisSqlSessionFactory {

	Logger log = LoggerFactory.getLogger(MyBatisSqlSessionFactory.class);
	private SqlSessionFactory sqlSessionFactory;

	protected static final Map<String, Map<String, String>> databaseSpecificStatements = new HashMap<String, Map<String, String>>();

	public static final Map<String, String> databaseSpecificLimitBeforeStatements = new HashMap<String, String>();
	public static final Map<String, String> databaseSpecificLimitAfterStatements = new HashMap<String, String>();
	public static final Map<String, String> databaseSpecificLimitBetweenStatements = new HashMap<String, String>();
	public static final Map<String, String> databaseSpecificOrderByStatements = new HashMap<String, String>();
	public static final Map<String, String> databaseOuterJoinLimitBetweenStatements = new HashMap<String, String>();
	public static final Map<String, String> databaseSpecificLimitBeforeNativeQueryStatements = new HashMap<String, String>();

	protected static Properties databaseTypeMappings = new Properties();

	static {

		String defaultOrderBy = " order by ${orderBy} ";
		// mysql specific
		databaseSpecificLimitBeforeStatements.put("mysql", "");
		databaseSpecificLimitAfterStatements.put("mysql", "LIMIT #{maxResults} OFFSET #{firstResult}");
		databaseSpecificLimitBetweenStatements.put("mysql", "");
		databaseOuterJoinLimitBetweenStatements.put("mysql", "");
		databaseSpecificOrderByStatements.put("mysql", defaultOrderBy);

		// oracle
		databaseSpecificLimitBeforeStatements.put("oracle", "select * from ( select a.*, ROWNUM rnum from (");
		databaseSpecificLimitAfterStatements.put("oracle",
				"  ) a where ROWNUM < #{lastRow}) where rnum  >= #{firstRow}");
		databaseSpecificLimitBetweenStatements.put("oracle", "");
		databaseOuterJoinLimitBetweenStatements.put("oracle", "");
		databaseSpecificOrderByStatements.put("oracle", defaultOrderBy);

		databaseSpecificLimitBeforeStatements.put("mssql", "SELECT SUB.* FROM (");
		databaseSpecificLimitAfterStatements.put("mssql",
				")RES ) SUB WHERE SUB.rnk >= #{firstRow} AND SUB.rnk < #{lastRow}");
		databaseSpecificLimitBetweenStatements.put("mssql",
				", row_number() over (ORDER BY #{orderBy}) rnk FROM ( select distinct RES.* ");
		databaseOuterJoinLimitBetweenStatements.put("mssql", "");
		databaseSpecificOrderByStatements.put("mssql", "");

		databaseTypeMappings.setProperty("MySQL", "mysql");
		databaseTypeMappings.setProperty("Oracle", "oracle");
		databaseTypeMappings.setProperty("Microsoft SQL Server", "mssql");
	}

	private SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		if (sqlSessionFactory == null) {
			throw new RuntimeException("mybatis sqlsession工厂创建失败");
		}
		sqlSession = sqlSessionFactory.openSession();
		if (sqlSession == null) {
			throw new RuntimeException("mybatis sqlSession创建失败");
		}
		return sqlSession;
	}

	public Class<?> getSessionType() {
		return ISqlSession.class;
	}

	public ISqlSession openSession() {
		return new MybatisSqlSession(getSqlSession());
	}

}
