package org.owl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.owl.json.Competitor;
import org.owl.site.Supervisor;
import org.owl.site.TaoBaoSupervisor;

import com.opensymphony.xwork2.Action;

/**
 * 
 * @author Kim 2014-01-26 13:46
 * @version 0.0.1
 */
public class JSONAction implements Action, ResultAction {

	private static final Log log = LogFactory.getLog(JSONAction.class);

	/**
	 * <p>客户端传过来的包含酒店价格信息的url地址参数。作为抓取价格的目标网页。</p>
	 * <p>必须为淘宝旅行某卖家的酒店宝贝链接。</p>
	 * 
	 * FIXME url中包含"&"链接符，这跟用户通过地址栏使用本接口，会发生冲突。改用"房型编号"作为输入参数。
	 */
	private String[] urls;

	/**
	 * <p>Struts2将data变量转换成JSON格式的字符串，发送到客户端。</p>
	 * <p>在目前版本，data变量只包含competitors这一个键值对值，如{"success":0, "competitors":[]}</p>
	 */
	private Map<String, Object> data;

	public String execute() {
		try {
			data = new HashMap<String, Object>();
			List<Competitor> competitorList = new ArrayList<Competitor>();
			
			data.put(COMPETITORS_KEY, competitorList);
		
			if (urls == null) {
				data.put(SUCCESS_KEY, URLS_IS_NULL);
				return SUCCESS;
			}

			Supervisor supervisor = new TaoBaoSupervisor();
			for (int i = 0, le = urls.length; i < le; i++) {
				String url = urls[i];
				String outerId = null;
				if (StringUtils.isNotBlank(url)) {
					url = url.trim();
					
					log.info(url);
					
					int index = url.lastIndexOf("/");
					outerId = url.substring(index + 1);
					
					String targetUrl = url.substring(0, index);
					
					Competitor competitor = supervisor.exe(targetUrl);
					competitor.setOuterId(outerId);

					competitorList.add(competitor);
				}
			}
			data.put(SUCCESS_KEY, SUCCESS_VAL);
		} catch (Exception e) {
			log.error("获取urls中的价格信息", e);
		}
		return SUCCESS;
	}

	/**
	 * 销毁方法。通过Spring调用。
	 */
	public void distory() {
		urls = null;
		data = null;
	}

	public void setUrls(String[] urls) {
		this.urls = urls;
	}

	public Map<String, Object> getData() {
		return data;
	}

}
