package db.model;

/**
 * 角色数据
 * @author Tqq
 *
 */
public class VrRole {
	private Integer roleId;
	private String roleName;
	private VrAdmin vrAdmin;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public VrAdmin getVrAdmin() {
		return vrAdmin;
	}
	public void setVrAdmin(VrAdmin vrAdmin) {
		this.vrAdmin = vrAdmin;
	}
}
