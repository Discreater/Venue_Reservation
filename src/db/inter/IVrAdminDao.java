package db.inter;

import db.model.VrAdmin;

public interface IVrAdminDao extends IBaseDao<VrAdmin, String> {
	// 管理员登录
	VrAdmin findOne(String adminName, String admimnPassword);
}
