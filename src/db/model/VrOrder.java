package db.model;

import java.sql.Date;

/**
 * 订单数据
 * @author Tqq
 *
 */
public class VrOrder {
	private Integer ordId;
	private Date ordSubmitTime;	// 订单提交时间
	private Date ordDealTime;	// 订单处理时间
	private Date useStartTime;	// 场馆开始占用时间
	private Date useEndTime;	// 场馆结束占用时间
	private String ordStatus;
	private String ordRejectReason;
	private Integer custId;
	private Integer adminId;
	private Integer venueId;
	
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public Integer getVenueId() {
		return venueId;
	}
	public void setVenueId(Integer venueId) {
		this.venueId = venueId;
	}

	public Integer getOrdId() {
		return ordId;
	}
	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
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
	public String getOrdRejectReason() {
		return ordRejectReason;
	}
	public void setOrdRejectReason(String ordRejectReason) {
		this.ordRejectReason = ordRejectReason;
	}

	
}