package org.owl.service.impl;

import java.util.List;

import org.owl.dao.CompetitorDao;
import org.owl.dao.finder.CompetitorFinder;
import org.owl.entity.Competitor;
import org.owl.service.CompetitorService;
import org.springframework.transaction.annotation.Transactional;

public class CompetitorServiceImpl implements CompetitorService {

	private CompetitorDao competitorDao;

	@Transactional(readOnly = true)
	public List<Competitor> findByRoomCd(Integer roomCd) {
		CompetitorFinder competitorFinder = new CompetitorFinder();
		competitorFinder.setRoomCd(roomCd);
		return competitorDao.find(competitorFinder);
	}
	
	@Transactional
	public String save(Competitor competitor) {
		return competitorDao.save(competitor);
	}

	public void setCompetitorDao(CompetitorDao competitorDao) {
		this.competitorDao = competitorDao;
	}

}
