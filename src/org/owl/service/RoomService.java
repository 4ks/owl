package org.owl.service;

import org.owl.entity.Room;

public interface RoomService {
	
	Room findById(String id);
	
	Room findByCd(Integer roomCd);
	
	String save(Room room);
	
}
