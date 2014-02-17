package org.owl.json;

/**
 * 
 * @author Kim
 *
 */
public class Competitor {
	
	private String outerId;
	
	private String startDate;

	private String prices;
	
	private String quotas;
	
	private String url;
	
	/**
	 * 淘宝网上"实价有房"标记
	 */
	private String realRoom;

	public String getPrices() {
		return prices;
	}

	public void setPrices(String prices) {
		this.prices = prices;
	}

	public String getQuotas() {
		return quotas;
	}

	public void setQuotas(String quotas) {
		this.quotas = quotas;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getOuterId() {
		return outerId;
	}

	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}

	public String getRealRoom() {
		return realRoom;
	}

	public void setRealRoom(String realRoom) {
		this.realRoom = realRoom;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

}