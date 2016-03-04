package com.frame.plugin;

import java.sql.Connection;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.RowBounds;

/**
 * MySQL分页
 * @Intercepts用于表明当前的对象是一个Intercepto
 * @Signature则表明要拦截的接口、方法以及对应的参数类型
 * @author master
 *
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class MySqlPaginationPlugin extends PaginationBasePlugin {
	@Override
	protected String paginationSql(String sql, RowBounds rowBounds) {
		sql = sql.trim();
		//计算第一条记录的位置，Mysql中记录的位置是从0开始的。
	    int offset = (rowBounds.getOffset() - 1) * rowBounds.getLimit();
		StringBuffer pagingSelect = new StringBuffer(sql);
		pagingSelect.append(" limit ").append(offset).append(",").append(rowBounds.getLimit());
		return pagingSelect.toString();
	}
}
