package db.inter;

import java.util.List;

import db.model.VrCustomer;

public interface IVrCustomerDao extends IBaseDao<VrCustomer, Integer>{
	// 用户登录
	VrCustomer findOne(String custName, String custPassword);
	
	List<VrCustomer> findPage(String custName, Integer PageSize, Integer pageNo);
	Integer findCount(String custName);
}
