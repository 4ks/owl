package org.owl.site;

import org.owl.json.Competitor;

/**
 * 不同网站抓取酒店价格的接口。分2步使用：1、使用verify方法，验证url的合理性；2、使用exe方法，拿到价格。
 * @author Kim
 *
 */
public interface Supervisor {
	
	/**
	 * 验证参数urlStr是否适合使用本实例的exe方法。
	 * @param urlStr
	 * @return
	 */
	boolean verify(String urlStr);
	
	/**
	 * 抓取酒店价格。使用此API前先调用verify方法验证参数是否适合使用exe方法。
	 * @param urlStr
	 * @return
	 */
	Competitor exe(String urlStr);

}
