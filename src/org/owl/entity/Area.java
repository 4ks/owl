package org.owl.entity;

/**
 * 地址
 * 
 * @author Kim
 * 
 */
public class Area {

	/**
	 * 标准行政区域代码.参考: 
	 * <a  href="http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201401/t20140116_501070.html" target="_blank">
	 * http://www.stats.gov.cn/tjsj/tjbz/xzqhdm/201401/t20140116_501070.html
	 * </a>
	 */
	private int id;
	
	/**
	 * 区域类型.area区域
	 * <ul>
	 * <li>1:country/国家;</li>
	 * <li>2:province/省/自治区/直辖市;</li>
	 * <li>3:city/地区(省下面的地级市);</li>
	 * <li>4:district/县/市(县级市)/区;</li>
	 * </ul>
	 * 比如北京市的type = 3,朝阳区是北京市的一个区,所以朝阳区的type = 4.
	 */
	private int type;

	/**
	 * 地域名称.如北京市,杭州市,西湖区,每一个area_id 都代表了一个具体的地区.
	 */
	private String name;

	/**
	 * 父节点区域标识.如北京市的area_id是110100,朝阳区是北京市的一个区,所以朝阳区的parent_id就是北京市的area_id.
	 */
	private Integer parentId;

	/**
	 * 邮政编码
	 */
	private String zip;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
