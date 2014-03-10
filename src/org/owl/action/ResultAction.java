package org.owl.action;

/**
 * 为统一 Action 返回结果，返回价格JSON的Action类需要实现这个接口，引用接口中的常量作为JSON的KEY值。
 * 
 * @author Kim
 * 
 */
public interface ResultAction {
	
	public static final String COMPETITORS_KEY = "competitors";
	public static final String SUCCESS_KEY = "success";
	
	public static final int SUCCESS_VAL = 0;
	public static final int URLS_IS_NULL = 1;
	public static final int ERROR = 2;

}
