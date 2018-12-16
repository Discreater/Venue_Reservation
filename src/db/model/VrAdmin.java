package db.model;

import java.sql.Date;
import java.util.List;

/**
 * 管理员数据
 * @author Tqq
 *
 */
public class VrAdmin {
	private Integer adminId;
	private String adminName;
	private String adminPassword;
	private Date adminCreatTime;
	private List<VrRole> vrRoleList;
	
	public VrAdmin() {
		super();
	}
	public VrAdmin(Integer adminId, String adminName, String adminPassword, Date adminCreatTime,
			List<VrRole> vrRoleList) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminCreatTime = adminCreatTime;
		this.vrRoleList = vrRoleList;
	}
	
	public Date getAdminCreatTime() {
		return adminCreatTime;
	}
	public void setAdminCreatTime(Date adminCreatTime) {
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
	public List<VrRole> getVrRoleList() {
		return vrRoleList;
	}
	public void setVrRoleList(List<VrRole> vrRoleList) {
		this.vrRoleList = vrRoleList;
	}
}
