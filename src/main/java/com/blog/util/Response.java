package com.blog.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

@SuppressWarnings("serial")
/**
 * @Description: 封装的返回方法
 * @Author:
 * @Date:
*/
public class Response extends HashMap<String,Object> {

	private final static String CODE = "code";
	private final static String DATA = "data";
	private final static String COUNT = "count";
	private final static String MESSAGE = "message";


	private Logger logger = LoggerFactory.getLogger(Response.class);

	/**
	 * @Description 默认返回code 0,，message OK
	 * @param
	 * @return
	*/
	private Response() {
		this.put(CODE, 0);
        this.put(MESSAGE, "OK");
	}

	private Response(int flag,String message) {
		this.put(CODE, flag);
		this.put(MESSAGE, message);
	}



    //构建方法------------------------------------------------------------------------------
	public static Response okResponse() {
		return new Response();
	}

	public static Response failResponse(){
		return new Response(666,"ERROR");
	}

	public static Response failResponse(String message){
		return new Response(666,message);
	}

    public static Response setResponse(Integer count, Object rows) {
        Response response = new Response();
        response.setCount(count);
        response.setData(rows);
        return response;
    }

    public static Response setResponse(Object rows) {
        Response response = new Response();
        response.setData(rows);
        return response;
    }

    public static Response setResponse(String key, Object value) {
        Response response = Response.okResponse();
        response.put(key, value);
        return response;
    }






	/**
	 * @param data
	 */
	public Response setData(Object data){
		this.put(DATA, data);
		return this;
	}
	
	public Response put(String key, Object value) {
		super.put(key, value);
		return this;
	}

	/**
	 * 获得错误消息
	 */
	public String getMessage() {
		Object msg = this.get(MESSAGE);
		return msg != null ? msg.toString() : null;
	}

	/**
	 * 获得Data内容
	 */
	public Object getData() {
		Object data = this.get(DATA);
		return data != null ? data : null;
	}

	/**
	 * @Description:  修改键名
	*/
	public Response moveTo(String fromKey, String toKey) {
		Object val = this.get(fromKey);
		this.put(toKey, val);
		this.remove(fromKey);
		return this;
	}


	public Response setResults(Integer count, Object data) {
		this.setCount(count);
		this.setData(data);
		return this;
	}
	
	private Response setCode(int code) {
		this.put(CODE, code);
		return this;
	}

	public Response setCodeAndMessage(int code, String message) {
		this.put(CODE, code);
		this.put(MESSAGE, message);
		return this;
	}

    public Response setMessage(String message) {
        this.put(MESSAGE, message);
        return this;
    }

	public int getCode() {
		return Integer.parseInt(this.get(CODE).toString());
	}
	

	public Response setCount(Integer count) {
		this.put(COUNT, count);
		return this;
	}

}