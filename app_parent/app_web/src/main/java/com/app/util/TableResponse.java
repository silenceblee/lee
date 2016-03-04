package com.app.util;

import java.util.List;
import java.util.Map;

/**
 * 列表请求返回数据
 * @author master
 *
 * @param <T> 数据集
 */
public class TableResponse<T> {
	/**当前页码*/ 
    private int page; 
	/**需要显示的数据集  */
    private List<T> rows;  
    /**数据总数*/
    private int records;  
    /**可显示的页数 */
    private int total;  
    /**自定义数据 */
    private Map<String, Object> userdata;
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRecords() {
		return records;
	}
	public void setRecords(int records) {
		this.records = records;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Map<String, Object> getUserdata() {
		return userdata;
	}
	public void setUserdata(Map<String, Object> userdata) {
		this.userdata = userdata;
	}
    
    
}
