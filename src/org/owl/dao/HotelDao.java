package org.owl.dao;

import org.owl.entity.Hotel;

public interface HotelDao {
	
	String save(Hotel hotel);
	
	void delete(String id);
	
	void update(Hotel hotel);
	
	Hotel get(String id);

}
