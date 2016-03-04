package com.frame.plugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.PropertyException;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.frame.common.Page;
import com.frame.common.ReflectHelper;

/**
 * 拦截器，用于分页
 * @author master
 *
 */
public abstract class PaginationBasePlugin implements Interceptor {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private static String pageSqlId;

	public Object intercept(Invocation invocation) throws Throwable {
		if (invocation.getTarget() instanceof RoutingStatementHandler) {
			RoutingStatementHandler statementHandler = (RoutingStatementHandler) invocation.getTarget();
			BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(statementHandler,"delegate");
			MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate,"mappedStatement");
			if (mappedStatement.getId().matches(pageSqlId)) {
				BoundSql boundSql = delegate.getBoundSql();
				//RowBounds rowBounds = (RowBounds) ReflectHelper.getValueByFieldName(delegate, "rowBounds");
				// 分页SQL<select>中parameterType属性对应的实体参数，即Mapper接口中执行分页方法的参数,该参数不得为空
				Object parameterObject = boundSql.getParameterObject();
				if (parameterObject == null) {
					//throw new NullPointerException("parameterObject尚未实例化！");
				} else {
					Page page = (Page)parameterObject;
					if(page.isPagination()){//是否分页
						RowBounds rowBounds = new RowBounds(page.getPage(),page.getRows());
						Connection connection = (Connection) invocation.getArgs()[0];
						//page.setTotalRecord(getSelectTotalCount(connection, boundSql, mappedStatement));
						setTotalRecord(page, mappedStatement, connection);
						// 将分页sql语句反射回BoundSql.
						ReflectHelper.setValueByFieldName(boundSql, "sql", paginationSql(boundSql.getSql(), rowBounds));
						// 将rowBounds反射为无限制，否则mybatis会根据rowBounds把select的结果列表再做一次过滤
						ReflectHelper.setValueByFieldName(rowBounds, "offset", RowBounds.NO_ROW_OFFSET);
						ReflectHelper.setValueByFieldName(rowBounds, "limit", RowBounds.NO_ROW_LIMIT);
					}
				}
			}
		}
		Object result = invocation.proceed();
		return result;
	}

	  /**
     * 给当前的参数对象page设置总记录数
     *
     * @param page Mapper映射语句对应的参数对象
     * @param mappedStatement Mapper映射语句
     * @param connection 当前的数据库连接
     */
    private void setTotalRecord(Page page, MappedStatement mappedStatement, Connection connection) {
       //获取对应的BoundSql，这个BoundSql其实跟我们利用StatementHandler获取到的BoundSql是同一个对象。
       //delegate里面的boundSql也是通过mappedStatement.getBoundSql(paramObj)方法获取到的。
       BoundSql boundSql = mappedStatement.getBoundSql(page);
       //获取到我们自己写在Mapper映射语句中对应的Sql语句
       String sql = boundSql.getSql();
       //通过查询Sql语句获取到对应的计算总记录数的sql语句
		int index = sql.indexOf("from");
		String countSql =  "select count(1) " + sql.substring(index);
       //通过BoundSql获取对应的参数映射
       List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
       //利用Configuration、查询记录数的Sql语句countSql、参数映射关系parameterMappings和参数对象page建立查询记录数对应的BoundSql对象。
       BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings, page);
       //通过mappedStatement、参数对象page和BoundSql对象countBoundSql建立一个用于设定参数的ParameterHandler对象
       ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, page, countBoundSql);
       //通过connection建立一个countSql对应的PreparedStatement对象。
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       try {
           pstmt = connection.prepareStatement(countSql);
           //通过parameterHandler给PreparedStatement对象设置参数
           parameterHandler.setParameters(pstmt);
           //之后就是执行获取总记录数的Sql语句和获取结果了。
           rs = pstmt.executeQuery();
           if (rs.next()) {
              int totalRecord = rs.getInt(1);
              //给当前的参数page对象设置总记录数
              page.setRecords(totalRecord);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           try {
              if (rs != null)
                  rs.close();
               if (pstmt != null)
                  pstmt.close();
           } catch (SQLException e) {
              e.printStackTrace();
           }
       }
    }
   
/*	
	private int getSelectTotalCount(Connection connection, BoundSql boundSql, MappedStatement mappedStatement)
			throws SQLException, SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
		ResultSet rs = null;
		PreparedStatement countStmt = null;

		try {
			String countSql = "select count(1) from (" + boundSql.getSql() + ")"; // 记录统计
			countStmt = connection.prepareStatement(countSql);			
			BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
					boundSql.getParameterMappings(), boundSql.getParameterObject());	
			@SuppressWarnings("unchecked")
			Map<String, Object> additionalParameters = (Map<String, Object>) ReflectHelper.getValueByFieldName(boundSql, "additionalParameters");
			for (Entry<String, Object> entry : additionalParameters.entrySet()) {
				countBS.setAdditionalParameter(entry.getKey(), entry.getValue());
			}			
			
			setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());
			rs = countStmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}

			return 0;

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception ex) {
				}
			}

			if (countStmt != null) {
				try {
					countStmt.close();
				} catch (Exception ex) {
				}
			}
		}
	}*/

	/** 
	 * 对SQL参数(?)设值,参考org.apache.ibatis.executor.parameter.DefaultParameterHandler 
	 * @param ps 
	 * @param mappedStatement 
	 * @param boundSql 
	 * @param parameterObject 
	 * @throws SQLException 
	 */
	/*@SuppressWarnings("unchecked")
	private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
			Object parameterObject) throws SQLException {
		ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		if (parameterMappings != null && parameterMappings.size() > 0) {
			Configuration configuration = mappedStatement.getConfiguration();
			TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
			MetaObject metaObject = parameterObject == null ? null : configuration.newMetaObject(parameterObject);
			for (int i = 0; i < parameterMappings.size(); i++) {
				ParameterMapping parameterMapping = parameterMappings.get(i);
				if (parameterMapping.getMode() != ParameterMode.OUT) {
					Object value;
					String propertyName = parameterMapping.getProperty();
					PropertyTokenizer prop = new PropertyTokenizer(propertyName);
					if (parameterObject == null) {
						value = null;
					} else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
						value = parameterObject;
					} else if (boundSql.hasAdditionalParameter(propertyName)) {
						value = boundSql.getAdditionalParameter(propertyName);
					} else if (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX)
							&& boundSql.hasAdditionalParameter(prop.getName())) {
						value = boundSql.getAdditionalParameter(prop.getName());
						if (value != null) {
							value = configuration.newMetaObject(value).getValue(
									propertyName.substring(prop.getName().length()));
						}
					} else {
						value = metaObject == null ? null : metaObject.getValue(propertyName);
					}
					@SuppressWarnings("rawtypes")
					TypeHandler typeHandler = parameterMapping.getTypeHandler();
					if (typeHandler == null) {
						throw new ExecutorException("There was no TypeHandler found for parameter " + propertyName
								+ " of statement " + mappedStatement.getId());
					}
					typeHandler.setParameter(ps, i + 1, value, parameterMapping.getJdbcType());
				}
			}
		}
	}
*/
	protected abstract String paginationSql(String sql, RowBounds rowBounds); // 子类实现

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		pageSqlId = properties.getProperty("pageSqlId");
		if (StringUtils.isBlank(pageSqlId)) {
			try {
				throw new PropertyException("pageSqlId property is not found!");
			} catch (PropertyException e) {
				logger.error(e.getMessage());
			}
		}
	}

	public static String getPageSqlId() {
		return pageSqlId;
	}

	public static void setPageSqlId(String pageSqlId) {
		PaginationBasePlugin.pageSqlId = pageSqlId;
	}
}
