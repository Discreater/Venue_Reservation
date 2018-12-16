package db.model;

import java.sql.Date;

/**
 * 场馆数据
 * @author Tqq
 *
 */
public class VrVenue {
	private Integer venueId = null;
	private String venueName = null;
	
	private String venueOwnerName = null;		// 拥有者
	private String venueOwnerPhone = null;
	private String venueOwnerEmail = null;
	private String venueOwnerAddress = null;
	
	private String venuePicture = null;
	private String venueAddress = null;
	private String venueInfo = null;
	/**
	 * valid,invalid
	 */
	private String venueState = "valid";
	private Date venueCreateTime = null;
	
	
	
	public String getVenueInfo() {
		return venueInfo;
	}
	public void setVenueInfo(String venueInfo) {
		this.venueInfo = venueInfo;
	}
	public Integer getVenueId() {
		return venueId;
	}
	public void setVenueId(Integer venueId) {
		this.venueId = venueId;
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public String getVenueOwnerName() {
		return venueOwnerName;
	}
	public void setVenueOwnerName(String venueOwnerName) {
		this.venueOwnerName = venueOwnerName;
	}
	public String getVenueOwnerPhone() {
		return venueOwnerPhone;
	}
	public void setVenueOwnerPhone(String venueOwnerPhone) {
		this.venueOwnerPhone = venueOwnerPhone;
	}
	public String getVenueOwnerEmail() {
		return venueOwnerEmail;
	}
	public void setVenueOwnerEmail(String venueOwnerEmail) {
		this.venueOwnerEmail = venueOwnerEmail;
	}
	public String getVenueOwnerAddress() {
		return venueOwnerAddress;
	}
	public void setVenueOwnerAddress(String venueOwnerAddress) {
		this.venueOwnerAddress = venueOwnerAddress;
	}
	public String getVenuePicture() {
		return venuePicture;
	}
	public void setVenuePicture(String venuePicture) {
		this.venuePicture = venuePicture;
	}
	public String getVenueAddress() {
		return venueAddress;
	}
	public void setVenueAddress(String venueAddress) {
		this.venueAddress = venueAddress;
	}
	public String getVenueState() {
		return venueState;
	}
	public void setVenueState(String venueState) {
		this.venueState = venueState;
	}
	public Date getVenueCreateTime() {
		return venueCreateTime;
	}
	public void setVenueCreateTime(Date venueCreateTime) {
		this.venueCreateTime = venueCreateTime;
	}

	

	
}
