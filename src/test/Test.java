package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import db.acess.VrAdminDao;
import db.acess.VrVenueDao;
import db.model.VrAdmin;
import db.model.VrVenue;

public class Test {

	public static void main(String[] args) {
		System.out.println("For test");
		testInsertVrVenue();


	}
	
	public static void testInsertVrVenue() {
		VrVenueDao vrVenueDao = new VrVenueDao();
		VrVenue vrVenue = new VrVenue();
		vrVenue.setVenueName("ACNU");
		vrVenue.setVenueOwnerName("Znuer");
		vrVenue.setVenueOwnerPhone("923456");
		vrVenue.setVenueAddress("A金沙江");
		vrVenue.setVenueInfo("z无");
		vrVenue.setVenueState("valid");
		vrVenueDao.insert(vrVenue);
	}
	
	public static void testfindVrAdmin() {
		List<VrAdmin> vrAdmins = new ArrayList<>();
		VrAdminDao vrAdminDao = new VrAdminDao(); 
		vrAdmins = vrAdminDao.findAll();
		VrAdmin vrAdmin = null;
		Iterator<VrAdmin> iterator = vrAdmins.iterator();
		while (iterator.hasNext()) {
			vrAdmin = iterator.next();
			System.out.println(vrAdmin.getAdminName() + " " + vrAdmin.getAdminPassword());
		}
	}
	public static void testInsertVrAdmin() {
		VrAdminDao vrAdminDao = new VrAdminDao();
		VrAdmin vrAdmin = new VrAdmin();
		vrAdmin.setAdminName("ly");
		vrAdmin.setAdminPassword("lyvrtest");
		vrAdminDao.insert(vrAdmin);
	}
	public static void testDeleteVrAdmin() {
		VrAdminDao vrAdminDao = new VrAdminDao();
		vrAdminDao.delete(3);
	}

}
