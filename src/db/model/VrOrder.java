package db.model;

import java.sql.Timestamp;

/**
 * 订单数据
 * @author Tqq
 *
 */
public class VrOrder {
	private Integer ordId = null;
	private Timestamp ordSubmitTime = null;	// 订单提交时间
	private Timestamp ordDealTime = null;	// 订单处理时间
	private Timestamp useStartTime = null;	// 场馆开始占用时间
	private Timestamp useEndTime = null;	// 场馆结束占用时间
	private String ordStatus = "wait";
	private String ordRejectReason = "";
	private Integer custId = null;
	private Integer adminId = null;
	private Integer venueId = null;
	private String ordSubmitReason = "";
	
	
	public Timestamp getOrdSubmitTime() {
		return ordSubmitTime;
	}
	public void setOrdSubmitTime(Timestamp ordSubmitTime) {
		this.ordSubmitTime = ordSubmitTime;
	}
	public Timestamp getOrdDealTime() {
		return ordDealTime;
	}
	public void setOrdDealTime(Timestamp ordDealTime) {
		this.ordDealTime = ordDealTime;
	}
	public Timestamp getUseStartTime() {
		return useStartTime;
	}
	public void setUseStartTime(Timestamp useStartTime) {
		this.useStartTime = useStartTime;
	}
	public Timestamp getUseEndTime() {
		return useEndTime;
	}
	public void setUseEndTime(Timestamp useEndTime) {
		this.useEndTime = useEndTime;
	}
	public String getOrdSubmitReason() {
		return ordSubmitReason;
	}
	public void setOrdSubmitReason(String ordSubmitReason) {
		this.ordSubmitReason = ordSubmitReason;
	}
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