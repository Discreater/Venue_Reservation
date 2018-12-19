package db.inter;

import java.util.List;

import db.model.VrVenue;

public interface IVrVenueDao extends IBaseDao<VrVenue, Integer> {
	List<VrVenue> findPageByVenueName(String catVenueName, Integer pageSize, Integer pageNo);
	List<VrVenue> findPageByOwnerName(String catOwnerName, Integer pageSize, Integer pageNo);
	List<VrVenue> findPageByAddress(String catVenueAddress, Integer pageSize, Integer pageNo);
	List<VrVenue> findPageByInfo(String catInfo, Integer pageSize, Integer pageNo);
	List<VrVenue> findPageByState(String state, Integer pageSize, Integer pageNo);
	VrVenue findByName(String name);
//	Integer findCount(Integer catId, String venueName);
}
