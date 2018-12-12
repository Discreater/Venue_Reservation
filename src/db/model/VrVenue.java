package db.model;

import java.util.List;

/**
 * 场馆数据
 * @author Tqq
 *
 */
public class VrVenue {
	private Integer venueId;
	private String venueName;
	
	private String venueOwner;		// 拥有者
	private String venueOwnerGender;
	private String venueOwnerPhone;
	private String venueOwnerEmail;
	private String venueOwnerAdress;
	
	private String venuePicture;
	private String venueAdress;
	private List<VrOrder> orders;
	
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
	public String getVenueOwner() {
		return venueOwner;
	}
	public void setVenueOwner(String venueOwner) {
		this.venueOwner = venueOwner;
	}
	public String getVenueOwnerGender() {
		return venueOwnerGender;
	}
	public void setVenueOwnerGender(String venueOwnerGender) {
		this.venueOwnerGender = venueOwnerGender;
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
	public String getVenueOwnerAdress() {
		return venueOwnerAdress;
	}
	public void setVenueOwnerAdress(String venueOwnerAdress) {
		this.venueOwnerAdress = venueOwnerAdress;
	}
	public String getVenuePicture() {
		return venuePicture;
	}
	public void setVenuePicture(String venuePicture) {
		this.venuePicture = venuePicture;
	}
	public String getVenueAdress() {
		return venueAdress;
	}
	public void setVenueAdress(String venueAdress) {
		this.venueAdress = venueAdress;
	}
	public List<VrOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<VrOrder> orders) {
		this.orders = orders;
	} 
	
}
