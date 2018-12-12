package service.iter;

import java.util.List;

import db.model.VrCustomer;

public interface IVrCustomerService {
	void addVrCustomer(VrCustomer vrCustomer);

	void deleteVrCustomer(Integer custId);

	VrCustomer findVrCustomerById(Integer custId);

	VrCustomer findVrCustomer(String custName, String custPassword);

	List<VrCustomer> findVrCustomersByPage(String custName, Integer pageSize, Integer pageNo);

	Integer findCount(String custName);
}
