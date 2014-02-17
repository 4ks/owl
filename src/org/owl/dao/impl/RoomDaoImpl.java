package org.owl.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.owl.dao.RoomDao;
import org.owl.dao.finder.RoomFinder;
import org.owl.entity.Room;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class RoomDaoImpl extends HibernateDaoSupport implements RoomDao {

	public Room get(String id) {
		return (Room) this.getHibernateTemplate().get(Room.class, id);
	}

	public String save(Room room) {
		this.getHibernateTemplate().save(room);
		return room.getId();
	}
	
	@SuppressWarnings("unchecked")
	public List<Room> find(RoomFinder roomFinder) {
		Criteria criteria = this.getSession().createCriteria(Room.class);
		
		Integer cd = roomFinder.getCd();
		if (cd != null) {
			criteria.add(Restrictions.like("cd", "%" + cd + "%"));
		}
		
		return criteria.list();
	}

}
