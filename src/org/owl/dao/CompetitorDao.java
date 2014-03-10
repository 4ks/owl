package org.owl.dao;

import java.util.List;

import org.owl.dao.finder.CompetitorFinder;
import org.owl.entity.Competitor;

public interface CompetitorDao {
	
	String save(Competitor competitor);
	
	String update(Competitor competitor);
	
	List<Competitor> find(CompetitorFinder competitorFinder);

}
