package db.iter;

import java.util.List;

import db.model.VrVenue;

public interface IVrVenueDao extends IBaseDao<VrVenue, Integer> {
	List<VrVenue> findPage(Integer catId, String venueName, Integer pageSize, Integer pageNo);
	Integer findCount(Integer catId, String venueName);
}
