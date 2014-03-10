package org.owl.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.owl.dao.CompetitorDao;
import org.owl.dao.finder.CompetitorFinder;
import org.owl.entity.Competitor;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CompetitorDaoImpl extends HibernateDaoSupport implements CompetitorDao {

	@SuppressWarnings("unchecked")
	public List<Competitor> find(CompetitorFinder competitorFinder) {
		Criteria criteria = this.getSession().createCriteria(Competitor.class);
		Integer roomCd = competitorFinder.getRoomCd();
		if (roomCd != null) {
			criteria.createCriteria("room").add(Restrictions.eq("cd", roomCd));
		}
		
		return criteria.list();
	}

	public String save(Competitor competitor) {
		this.getHibernateTemplate().save(competitor);
		return competitor.getId();
	}

	public String update(Competitor competitor) {
		this.getHibernateTemplate().update(competitor);
		return competitor.getId();
	}

}
