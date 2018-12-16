package db.acess;

import java.util.List;

import db.inter.IVrCommitDao;
import db.model.VrCommit;

public class VrCommitDao implements IVrCommitDao {

	@Override
	public void insert(VrCommit obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(VrCommit obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VrCommit findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VrCommit> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VrCommit> findPage(int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<VrCommit> findByCustId(Integer custId, Integer pageSize, Integer pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VrCommit> findByAdminId(Integer adminId, Integer pageSize, Integer pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer findCount(Integer custId) {
		// TODO Auto-generated method stub
		return null;
	}

}
