package db.model;

import java.sql.Timestamp;

/**
 * 管理员数据
 * @author Tqq
 *
 */
public class VrAdmin {
	private Integer adminId = null;
	private String adminName = null;
	private String adminPassword = null;
	private Timestamp adminCreatTime = null;
	
	
	public Timestamp getAdminCreatTime() {
		return adminCreatTime;
	}
	public void setAdminCreatTime(Timestamp adminCreatTime) {
		this.adminCreatTime = adminCreatTime;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
}
