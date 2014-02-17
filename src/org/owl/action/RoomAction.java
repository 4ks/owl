package org.owl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.owl.json.Competitor;
import org.owl.service.CompetitorService;
import org.owl.site.Supervisor;
import org.owl.site.TaoBaoSupervisor;

import com.opensymphony.xwork2.Action;

public class RoomAction implements Action, ResultAction {
	
	private static final Log log = LogFactory.getLog(RoomAction.class);
	
	/**
	 * <p>Struts2将data变量转换成JSON格式的字符串，发送到客户端。</p>
	 * <p>在目前版本，data变量只包含competitors这一个键值对值，如{"success":0, "competitors":[]}</p>
	 */
	private Map<String, Object> data;
	
	/**
	 * 房型编号
	 */
	private Integer roomCd;
	
	private CompetitorService competitorService;

	public String execute() {
		try {
			data = new HashMap<String, Object>();
			List<Competitor> competitorList = new ArrayList<Competitor>();
			
			log.info("the param roomCd is " + roomCd);
			
			List<org.owl.entity.Competitor> list = competitorService.findByRoomCd(roomCd);
			
			Supervisor supervisor = new TaoBaoSupervisor();
			for (org.owl.entity.Competitor competitor : list) {
				String url = competitor.getUrl();
				log.info("the url is " + url);
				Competitor c = supervisor.exe(url);
				
				competitorList.add(c);
			}
			
			data.put(COMPETITORS_KEY, competitorList);
		} catch (Exception e) {
			log.error("获取房型的所有价格信息", e);
		}
		return SUCCESS;
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
