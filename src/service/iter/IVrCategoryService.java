package service.iter;

import java.util.List;

import db.model.VrCategory;

public interface IVrCategoryService {
	void addVrCategory(VrCategory vrCategory);
	void editVrCategory(VrCategory vrCategory);
	void deleteVrCategory(VrCategory vrCategory);
	VrCategory findVrCategoryById(Integer catId);
	List<VrCategory> fidnAllCategories();
}
