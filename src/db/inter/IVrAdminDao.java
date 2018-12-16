package db.inter;

import db.model.VrAdmin;

public interface IVrAdminDao extends IBaseDao<VrAdmin, Integer> {
	// 管理员登录
	VrAdmin findOne(String adminName, String admimnPassword);
	VrAdmin findByName(String adminName);
}
