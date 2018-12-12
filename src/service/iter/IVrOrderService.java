package service.iter;

import java.util.List;

import db.model.VrOrder;

public interface IVrOrderService {
	void addVrOrder(VrOrder vrOrder);
	void editVrOrderState(Integer ordId, String ordOrderState);
	void deleteVrOrder(Integer ordId);
	VrOrder findVrOrderById(Integer ordId);
	List<VrOrder> findVrOrederById(Integer ordId);
	Integer findCount(Integer custId);
}
