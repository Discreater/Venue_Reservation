package db.model;

import java.sql.Date;

/**
 * 订单数据
 * @author Tqq
 *
 */
public class VrOrder {
	private Integer ordId;
	private VrVenue ordVenue;
	
	private Date ordSubmitTime;	// 订单提交时间
	private Date ordDealTime;	// 订单处理时间
	private Date useStartTime;	// 场馆开始占用时间
	private Date useEndTime;	// 场馆结束占用时间
	
	private String ordStatus;

	public VrOrder() {
		super();
	}
	
	public VrOrder(Integer ordId, VrVenue ordVenue, Date ordSubmitTime, Date ordDealTime, Date useStartTime,
			Date useEndTime, String ordStatus) {
		super();
		this.ordId = ordId;
		this.ordVenue = ordVenue;
		this.ordSubmitTime = ordSubmitTime;
		this.ordDealTime = ordDealTime;
		this.useStartTime = useStartTime;
		this.useEndTime = useEndTime;
		this.ordStatus = ordStatus;
	}


	public Integer getOrdId() {
		return ordId;
	}

	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}

	public VrVenue getOrdVenue() {
		return ordVenue;
	}

	public void setOrdVenue(VrVenue ordVenue) {
		this.ordVenue = ordVenue;
	}

	public Date getOrdSubmitTime() {
		return ordSubmitTime;
	}

	public void setOrdSubmitTime(Date ordSubmitTime) {
		this.ordSubmitTime = ordSubmitTime;
	}

	public Date getOrdDealTime() {
		return ordDealTime;
	}

	public void setOrdDealTime(Date ordDealTime) {
		this.ordDealTime = ordDealTime;
	}

	public Date getUseStartTime() {
		return useStartTime;
	}

	public void setUseStartTime(Date useStartTime) {
		this.useStartTime = useStartTime;
	}

	public Date getUseEndTime() {
		return useEndTime;
	}

	public void setUseEndTime(Date useEndTime) {
		this.useEndTime = useEndTime;
	}

	public String getOrdStatus() {
		return ordStatus;
	}

	public void setOrdStatus(String ordStatus) {
		this.ordStatus = ordStatus;
	}
	
	
}
