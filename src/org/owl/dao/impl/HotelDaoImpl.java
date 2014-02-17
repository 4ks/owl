package org.owl.dao.impl;

import org.owl.dao.HotelDao;
import org.owl.entity.Hotel;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HotelDaoImpl extends HibernateDaoSupport implements HotelDao {

	public void delete(String id) {
		Hotel hotel = this.get(id);
		this.getHibernateTemplate().delete(hotel);
	}

	public Hotel get(String id) {
		return (Hotel) this.getHibernateTemplate().get(Hotel.class, id);
	}

	public String save(Hotel hotel) {
		this.getHibernateTemplate().save(hotel);
		return hotel.getId();
	}

	public void update(Hotel hotel) {
		this.getHibernateTemplate().update(hotel);
	}

}
