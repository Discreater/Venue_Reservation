package db.model;

import java.sql.Date;

/**
 * 场馆数据
 * @author Tqq
 *
 */
public class VrVenue {
	private Integer venueId;
	private String venueName;
	
	private String venueOwnerName;		// 拥有者
	private String venueOwnerPhone;
	private String venueOwnerEmail;
	private String venueOwnerAddress;
	
	private String venuePicture;
	private String venueAddress;
	private String venueInfo;
	private String venueState;
	private Date venueCreateTime;
	
	
	
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
