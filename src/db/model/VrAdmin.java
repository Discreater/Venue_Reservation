package db.model;

import java.util.List;

/**
 * 管理员数据
 * @author Tqq
 *
 */
public class VrAdmin {
	private String adminName;
	private String adminPassword;
	private List<VrRole> vrRoleList;
	
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
