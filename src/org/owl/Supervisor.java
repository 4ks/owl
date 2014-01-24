package org.owl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author Kim
 * 
 */
public class Supervisor {

	private static final Log log = LogFactory.getLog(Supervisor.class);

	/**
	 * 根据淘宝链接URL去获取竞争对手价格信息
	 */
	public static Competitor exe(String urlStr) {
		Competitor competitor = null;
		
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			URL url = new URL(urlStr);
			isr = new InputStreamReader(url.openStream());
			br = new BufferedReader(isr);
			
			StringBuffer str = new StringBuffer();
			String strb = null;
			while ((strb = br.readLine()) != null) {
				str.append(strb);
			}
			
			String urlContent = str.toString();
			if (urlContent.contains("_hotel_data") && urlContent.contains("detail end")) {
				strb = urlContent.substring(str.toString().indexOf("_hotel_data"), str.toString().indexOf("detail end"));
				
				String strb1 = strb.substring(strb.indexOf("\"prices\":"));
				
				String strb2 = strb.substring(strb.indexOf("\"quotas\":"));
				
				strb1 = strb1.substring(strb1.indexOf("[") + 1, strb1.indexOf("]"));
				strb2 = strb2.substring(strb2.indexOf("[") + 1, strb2.indexOf("]"));
				
				competitor = new Competitor();
				competitor.setPrices(strb1);
				competitor.setQuotas(strb2);
			}
		} catch (MalformedURLException e) {
			log.error("URL格式错误", e);
		} catch (IOException e) {
			log.error("读取URL内容", e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					log.error("关闭BufferedReader", e);
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					log.error("关闭InputStreamReader", e);
				}
			}
		}
		
		return competitor;
	}

}
