package org.owl.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 
 * @author Kim
 *
 */
public class NullValueInterceptor implements Interceptor {

	private static final long serialVersionUID = -6541205125867327848L;

	public void destroy() {

	}

	public void init() {

	}

	/**
	 * TODO
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println(invocation.getInvocationContext().getName());
		
		System.out.println(invocation.getInvocationContext().getParameters());
		
		System.out.println("Action执行前插入 代码");
		
		//执行目标方法 (调用下一个拦截器, 或执行Action)
		final String res = invocation.invoke();
		
		System.out.println("Action执行后插入 代码");
		return res;
	}

}
