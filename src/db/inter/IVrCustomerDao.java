package db.inter;

import java.util.List;

import db.model.VrCustomer;

public interface IVrCustomerDao extends IBaseDao<VrCustomer, Integer>{
	/**
	 * 按name和password查找用户
	 * @param custName
	 * @param custPassword
	 * @return
	 */
	VrCustomer findOne(String custName, String custPassword);
	
	/**
	 * 按name查找用户
	 * @param custName
	 * @return
	 */
	VrCustomer findByName(String custName);
	List<VrCustomer> findPage(String catName, Integer pageSize, Integer pageNo);
	Integer findCount(String catName);
}
