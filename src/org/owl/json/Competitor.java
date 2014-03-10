package org.owl.json;

/**
 * 对外服务中返回JSON的格式对象。
 * 
 * @author Kim
 *
 */
public class Competitor {
	
	/**
	 * 外部ID，由调用者维护。
	 */
	private String outerId;
	
	/**
	 * 价格开始日期
	 */
	private String startDate;

	/**
	 * 酒店价格
	 */
	private String prices;
	
	/**
	 * 酒店房态
	 */
	private String quotas;
	
	/**
	 * 酒店url地址
	 */
	private String url;
	
	/**
	 * 淘宝网上"实价有房"标记。即将删除。
	 */
	@Deprecated
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
