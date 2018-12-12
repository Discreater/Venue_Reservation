package service.iter;

import java.util.List;

import db.model.VrRole;

public interface IVrRoleService {
	void addVrRole(VrRole vrRole);
	void editVrRole(VrRole vrRole);
	void deleteVrRole(Integer roleId);
	List<VrRole> findVrRolesByPage(Integer pageSize, Integer pageNo);
	Integer findCount();
}
