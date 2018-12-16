package db.inter;

import java.util.List;

import db.model.VrCommit;


public interface IVrCommitDao extends IBaseDao<VrCommit, Integer> {
	List<VrCommit> findByCustId(Integer custId, Integer pageSize, Integer pageNo);
	List<VrCommit> findByAdminId(Integer adminId, Integer pageSize, Integer pageNo);
	Integer findCount(Integer custId);
}
