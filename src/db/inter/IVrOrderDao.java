package db.inter;

import java.util.List;

import db.model.VrOrder;

public interface IVrOrderDao extends IBaseDao<VrOrder, Integer> {
	List<VrOrder> findByCustId(Integer custId, Integer pageSize, Integer pageNo);
	List<VrOrder> findByVenueId(Integer venueId, Integer pageSize, Integer pageNo);
	List<VrOrder> findByAdminId(Integer adminId, Integer pageSize, Integer pageNo);
	List<VrOrder> findByState(String orderState, Integer pageSize, Integer pageNo);
	List<VrOrder> findByReverse(Integer pageSize, Integer pageNo);
	Integer findCount(Integer custId);
}
