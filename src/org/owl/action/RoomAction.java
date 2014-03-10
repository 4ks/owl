package org.owl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.owl.json.Competitor;
import org.owl.service.CompetitorService;
import org.owl.site.Supervisor;
import org.owl.site.SupervisorManager;

import com.opensymphony.xwork2.Action;

/**
 * 实时加载1个酒店房型下，所有竞争对手的销售价格。对外的服务，用户可以通过API调用，返回监控的价格信息。
 * 
 * @author Kim 2014-02-19 16:27
 * @version 0.0.1
 */
public class RoomAction implements Action, ResultAction {

	private static final Log log = LogFactory.getLog(RoomAction.class);

	/**
	 * <p>Struts2将data变量转换成JSON格式的字符串，发送到客户端。</p>
	 * <p>在目前版本，data变量只包含competitors这一个键值对值，如{"success":0, "competitors":[]}</p>
	 */
	private Map<String, Object> data;

	/**
	 * 房型编号，由8位数字组成。
	 */
	private Integer roomCd;

	private CompetitorService competitorService;

	public String execute() {
		try {
			if (roomCd == null) {
				return SUCCESS;
			}
			
			log.info("the param roomCd is " + roomCd);
			List<Competitor> competitorList = this.queryCache(roomCd);

			data = new HashMap<String, Object>();
			// 为统一Map的键值，需引用ResultAction中的常量
			data.put(SUCCESS_KEY, SUCCESS_VAL);
			data.put(COMPETITORS_KEY, competitorList);
		} catch (Exception e) {
			log.error("获取房型的所有价格信息", e);
		}
		return SUCCESS;
	}
	
	/**
	 * 从缓存中取Competitor。当缓存不存在或者失效时，重新加载Competitor，并写入缓存中，方便下次查询。
	 */
	private static final String CACHE_KEY = "ehcache.competitor";
	@SuppressWarnings("unchecked")
	private List<Competitor> queryCache(Integer roomCd) {
		List<Competitor> competitorList = new ArrayList<Competitor>();
		
		CacheManager manager = CacheManager.create();
		Cache cache = manager.getCache(CACHE_KEY);
		log.debug("cache = " + cache);
		Element e = cache.getQuiet(roomCd);
		log.debug("element = " + e);
		if (e == null || cache.isExpired(e)) {
			List<org.owl.entity.Competitor> list = competitorService.findByRoomCd(roomCd);
			for (org.owl.entity.Competitor competitor : list) {
				String url = competitor.getUrl();
				log.info("the url is " + url);
				
				Supervisor supervisor = SupervisorManager.getSupervisorInstance(url);
				if (supervisor != null) {
					Competitor c = supervisor.exe(url);

					competitorList.add(c);
				}
			}
			
			e = new Element(roomCd, competitorList);
			cache.put(e);
		} else {
			competitorList = (List) e.getObjectValue();
		}

		return competitorList;
	}

	/**
	 * 销毁方法，通过Spring调用。加速Java垃圾回收速度。
	 */
	public void distory() {
		roomCd = null;
		data = null;
		competitorService = null;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setRoomCd(Integer roomCd) {
		this.roomCd = roomCd;
	}

	public void setCompetitorService(CompetitorService competitorService) {
		this.competitorService = competitorService;
	}

}
