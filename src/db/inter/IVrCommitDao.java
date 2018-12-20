package db.inter;

import java.util.List;

import db.model.VrCommit;


public interface IVrCommitDao extends IBaseDao<VrCommit, Integer> {
	List<VrCommit> findByCustId(Integer custId, Integer pageSize, Integer pageNo);
	List<VrCommit> findByAdminId(Integer adminId, Integer pageSize, Integer pageNo);
	List<VrCommit> findByState(String state, Integer pageSize, Integer pageNo);
	VrCommit findByHash(Integer hash); 
	Integer findCount(Integer custId);
}
