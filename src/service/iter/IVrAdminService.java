package service.iter;

import db.model.VrAdmin;

public interface IVrAdminService {
	VrAdmin findVrAdminByNameAndPassword(String adminName, String adminPassword);
	
}
