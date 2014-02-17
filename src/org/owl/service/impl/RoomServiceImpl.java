package org.owl.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.owl.dao.RoomDao;
import org.owl.dao.finder.RoomFinder;
import org.owl.entity.Room;
import org.owl.service.RoomService;
import org.springframework.transaction.annotation.Transactional;

public class RoomServiceImpl implements RoomService {
	
	private static final Log log = LogFactory.getLog(RoomServiceImpl.class);

	private RoomDao roomDao;

	@Transactional(readOnly = true)
	public Room findById(String id) {
		return roomDao.get(id);
	}
	
	@Transactional
	public String save(Room room) {
		return roomDao.save(room);
	}
	
	@Transactional(readOnly = true)
	public Room findByCd(Integer roomCd) {
		if (roomCd == null) {
			return null;
		}
		
		RoomFinder roomFinder = new RoomFinder();
		roomFinder.setCd(roomCd);
		
		List<Room> roomList = roomDao.find(roomFinder);
		
		int size = roomList.size();
		log.info("this size is " + size);
		if (size == 1) {
			return roomList.get(0);
		}
		
		return null;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

}
