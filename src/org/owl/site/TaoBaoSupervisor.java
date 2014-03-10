package org.owl.site;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.owl.json.Competitor;
import org.owl.util.TimeUtils;

/**
 * 淘宝网酒店价格抓取
 * 
 * @author Kim
 * 
 */
public class TaoBaoSupervisor implements Supervisor {

	private static final Log log = LogFactory.getLog(TaoBaoSupervisor.class);

	public Competitor exe(String urlStr) {
		Competitor competitor = null;
		
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		StringBuffer str = new StringBuffer();
		try {
			URL url = new URL(urlStr);
			isr = new InputStreamReader(url.openStream());
			br = new BufferedReader(isr);
			
			String strb = null;
			while ((strb = br.readLine()) != null) {
				str.append(strb);
			}
			
			String urlContent = str.toString();
			if (urlContent.contains("_hotel_data") && urlContent.contains("detail end")) {
				strb = urlContent.substring(str.toString().indexOf("_hotel_data"), str.toString().indexOf("detail end"));
				
				String strb1 = strb.substring(strb.indexOf("\"prices\":"));
				
				String strb2 = strb.substring(strb.indexOf("\"quotas\":"));
				
				String prices = strb1.substring(strb1.indexOf("[") + 1, strb1.indexOf("]"));
				String quotas = strb2.substring(strb2.indexOf("[") + 1, strb2.indexOf("]"));
				
				competitor = new Competitor();
				competitor.setPrices(prices);
				competitor.setQuotas(quotas);
				competitor.setUrl(urlStr);
				competitor.setStartDate(TimeUtils.current());
			}
			
			//实价有房
			int index = urlContent.indexOf("J_RealPrice");
			String realRoom = urlContent.substring(index, urlContent.indexOf("title", index));
			if (realRoom.indexOf("hidden") > 0) {
				competitor.setRealRoom("can");
			} else {
				competitor.setRealRoom("shi");
			}
		} catch (MalformedURLException e) {
			log.error("URL格式错误", e);
		} catch (Exception e) {
			log.error("获取淘宝酒店价格", e);
			log.error("淘宝网页html内容：" + str);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					log.error("closing BufferedReader", e);
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					log.error("closing InputStreamReader", e);
				}
			}
		}
		
		return competitor;
	}

	/**
	 * 淘宝网域名.用于检查参数url是否适合本类
	 */
	private static final String HOST = "taobao.com";
	
	/**
	 * 检验url是否属于淘宝网。<br />
	 * 属于淘宝网，返回true；反之，返回false;
	 */
	public boolean verify(String urlStr) {
		try {
			URL url = new URL(urlStr);
			String host = url.getHost();
			log.info("the host is " + host);
			
			boolean b = host.endsWith(HOST);
			log.info("verified url[" + urlStr + "] : " + b);
			
			return b;
		} catch (MalformedURLException e) {
			log.error("verify url", e);
		}
		return false;
	}

}
