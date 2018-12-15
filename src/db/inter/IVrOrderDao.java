package db.inter;

import java.util.List;

import db.model.VrOrder;

public interface IVrOrderDao extends IBaseDao<VrOrder, Integer> {
	List<VrOrder> find(Integer custId, Integer pageSize, Integer pageNo);
	Integer findCount(Integer catId);
}
