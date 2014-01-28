package org.owl.entity;

/**
 * 房型
 * @author Kim
 *
 */
public class Room {

	private long id;
	private String name;
	
	/**
	 * 房型编号。生成规则6位随机数字
	 */
	private int cd;

	private Hotel hotel;

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

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
