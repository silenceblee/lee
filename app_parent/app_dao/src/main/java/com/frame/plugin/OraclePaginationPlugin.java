package com.frame.plugin;

import java.sql.Connection;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.RowBounds;

/**
 * oracle分页
 * @Intercepts用于表明当前的对象是一个Intercepto
 * @Signature则表明要拦截的接口、方法以及对应的参数类型
 * @author master
 *
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class OraclePaginationPlugin extends PaginationBasePlugin {
	@Override
	protected String paginationSql(String sql, RowBounds rowBounds) {
		sql = sql.trim();
		 //计算第一条记录的位置，Oracle分页是通过rownum进行的，而rownum是从1开始的
	    int offset = (rowBounds.getLimit() - 1) * rowBounds.getOffset() + 1;
		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
		pagingSelect
				.append("select * from (select row_.* , rownum rownum_ from ( ");
		pagingSelect.append(sql);
		pagingSelect.append(" ) row_ where rownum <= ")
				.append(offset + rowBounds.getLimit())
				.append(" ) where rownum_ > ").append(offset);
		sql = pagingSelect.toString();
		return sql;
	}
}
