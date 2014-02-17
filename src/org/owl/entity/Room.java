package org.owl.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 房型
 * 
 * @author Kim
 * 
 */
public class Room {

	private String id;

	/**
	 * 房型名称
	 */
	private String name;

	/**
	 * 房型编号。生成规则8位随机数字
	 */
	private int cd;

	/**
	 * 所属的酒店
	 */
	private Hotel hotel;
	
	private Set<Competitor> competitors = new HashSet<Competitor>(0);

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

	public Set<Competitor> getCompetitors() {
		return competitors;
	}

	public void setCompetitors(Set<Competitor> competitors) {
		this.competitors = competitors;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
