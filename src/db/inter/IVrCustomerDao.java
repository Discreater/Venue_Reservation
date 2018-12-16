package db.inter;

import db.model.VrCustomer;

public interface IVrCustomerDao extends IBaseDao<VrCustomer, Integer>{
	/**
	 * 检查用
	 * @param custName
	 * @param custPassword
	 * @return
	 */
	VrCustomer findOne(String custName, String custPassword);
	
	/**
	 * 检查重名用
	 * @param custName
	 * @return
	 */
	VrCustomer findByName(String custName);
//  List<VrCustomer> findPage(String custName, Integer pageSize, Integer pageNo);
//	Integer findCount(String custName);
}
