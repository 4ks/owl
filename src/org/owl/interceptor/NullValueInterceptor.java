package org.owl.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 
 * @author Kim
 * 
 */
public class NullValueInterceptor implements Interceptor {

	private static final long serialVersionUID = -6541205125867327848L;
	
	private static final Log log = LogFactory.getLog(NullValueInterceptor.class);

	/**
	 * TODO
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		log.info(invocation.getInvocationContext().getName());
		log.info(invocation.getInvocationContext().getParameters());
		
		log.info("Action执行前插入代码");

		// 执行目标方法 (调用下一个拦截器, 或执行Action)
		final String res = invocation.invoke();
		
		log.info("Action执行后插入代码");

		return res;
	}

	public void destroy() {
	}

	public void init() {
	}

}
