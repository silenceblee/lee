package com.frame.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 列表发送数据
 * @author master
 *
 */
public class Page implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**当前页码*/  
    private int page = 1;  
    /**页面可显示行数*/  
    private int rows = 10;  
    /**数据总数*/
    private int records;
    /**用于排序的列名*/  
    private String sidx;  
    /**排序的方式desc/asc*/  
    private String sord;  
    /**是否是搜索请求*/  
    private boolean search;  
    /**已经发送的请求的次数*/  
    private String nd;
    /**是否分页*/
    private boolean pagination = true;
    /**其他的参数我们把它分装成一个Map对象*/
    private Map<String, Object> condition = new HashMap<String, Object>();
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	public boolean isSearch() {
		return search;
	}
	public void setSearch(boolean search) {
		this.search = search;
	}
	public String getNd() {
		return nd;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	
	public boolean isPagination() {
		return pagination;
	}
	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}
	 
	public Map<String, Object> getCondition() {
		return condition;
	}
	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}
	public int getRecords() {
		return records;
	}
	public void setRecords(int records) {
		this.records = records;
	}
}
