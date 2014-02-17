package org.owl.entity;

/**
 * 竞争者发布的酒店商品
 * 
 * @author Kim
 * 
 */
public class Competitor {

	private String id;
	
	private String name;

	private String url;

	private Room room;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
