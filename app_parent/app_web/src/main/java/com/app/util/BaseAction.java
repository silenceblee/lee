package com.app.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.frame.common.Page;





/**
 * 控制层基础类
 * @author master
 *
 */
public class BaseAction {
	/**默认字符编码*/
	private static final String DEFAULT_CHAR_SET = "UTF-8";
	/**
	 * 将查询的数据转换为分页请求数据
	 * @param <T>
	 * @param page 分页参数
	 * @param datas 查询数据
	 * @return
	 */
	protected  <T> TableResponse<T> toTableResponse(Page page,List<T> datas){
		TableResponse<T> tableResponse = new TableResponse<T>();
		tableResponse.setRows(datas);
		if(page != null && page.isPagination()){
			tableResponse.setPage(page.getPage());
			int totalRecord = page.getRecords();
			tableResponse.setRecords(totalRecord);
			int pageSize = page.getRows();
			int totalPage = totalRecord/pageSize;
		    totalPage = totalRecord%pageSize==0 ? totalPage : totalPage + 1;
			tableResponse.setTotal(totalPage);
		}
		return tableResponse;
	}
	/**
	 * 页面跳转
	 * @param path 返回页面路径
	 * @return
	 */
	@RequestMapping("/forward")
	public String forward(String path){
		return path;
	}
	
	/**
	 * 获取request请求
	 * @return
	 */
	protected HttpServletRequest getRequest(){
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
	}
	
	/**
	 * 获取response请求
	 * @return
	 */
	protected HttpServletResponse getResponse(){
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	/**
	 * 向客户端返回错误信息提示
	 * @param msg
	 */
	protected void errorMsg(Object msg){
		JSONObject obj = new JSONObject();
		obj.put("state", "error");
		obj.put("msg", msg);
		sendAjaxInfo(obj.toString());
	}
	

	/**
	 * Ajax返回的信息,Action方法调用后,必须return null
	 * 
	 * @param responseStr
	 */
	protected void sendAjaxInfo(String responseStr) {
		try {
			HttpServletResponse response = getResponse();
			PrintWriter out = response.getWriter();
			response.setCharacterEncoding(DEFAULT_CHAR_SET);
			response.setContentType("text/html");
			//response.setContentLength(responseStr.getBytes(DEFAULT_CHAR_SET).length);
			out.print(responseStr);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
