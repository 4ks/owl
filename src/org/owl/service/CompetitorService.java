package org.owl.service;

import java.util.List;

import org.owl.entity.Competitor;

public interface CompetitorService {
	
	String save(Competitor competitor);
	
	String update(Competitor competitor);

	List<Competitor> findByRoomCd(Integer roomCd);

}
