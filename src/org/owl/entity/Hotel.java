package org.owl.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 酒店
 * @author Kim
 *
 */
public class Hotel {

	private long id;
	private String name;
	
	/**
	 * 酒店编号。生成规则6位随机数字
	 */
	private int cd;

	private Set<Room> rooms = new HashSet<Room>(0);

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCd() {
		return cd;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

}
