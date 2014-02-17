package org.owl.dao;

import java.util.List;

import org.owl.dao.finder.RoomFinder;
import org.owl.entity.Room;

public interface RoomDao {

	Room get(String id);
	
	String save(Room room);
	
	List<Room> find(RoomFinder roomFinder);
	
}
