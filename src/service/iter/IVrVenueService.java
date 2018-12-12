package service.iter;

import java.util.List;

import db.model.VrCategory;
import db.model.VrVenue;

public interface IVrVenueService {
	void addVrVenue(VrVenue vrVenue);
	void editVrVenue(VrVenue vrVenue);
	void deleteVrVenue(VrVenue vrVenue);
	VrCategory findVrCategoryById(Integer catId);
	List<VrVenue> findVrVenuesByPage(Integer catId, String VenueName, Integer pageSize, Integer pageNo);
	Integer findCount(Integer catId, String VenueName);
}
