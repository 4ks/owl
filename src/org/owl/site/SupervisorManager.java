package org.owl.site;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 根据具体url，匹配Supervisor
 * 
 * @author Kim
 *
 */
public final class SupervisorManager {
	
	private static final Log log = LogFactory.getLog(SupervisorManager.class);
	
	/**
	 * 存放不同网站的取酒店价格实现类
	 */
	private static List<Supervisor> superList = new ArrayList<Supervisor>();
	
	static {
		superList.add(new TaoBaoSupervisor());
		log.info("loaded TaoBaoSupervisor");
		
		superList.add(new QunarSupervisor());
		log.info("loaded QunarSupervisor");
	}
	
	private SupervisorManager() {
	}
	
	/**
	 * 匹配适合参数url取价的实现类
	 * 
	 * @param url
	 * @return
	 */
	public static Supervisor getSupervisorInstance(String url) {
		log.info("the param url is [" + url + "]");
		for (Supervisor supervisor : superList) {
			if (supervisor.verify(url)) {
				log.info("the url[" + url + "] matches the " + supervisor);
				
				return supervisor;
			}
		}
		
		log.info("did not match the url[" + url + "] and supervisors");
		return null;
	}
}
