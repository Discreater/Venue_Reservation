package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import db.acess.VrAdminDao;
import db.acess.VrCustomerDao;
import db.acess.VrVenueDao;
import db.model.VrAdmin;
import db.model.VrCustomer;
import db.model.VrVenue;

public class Test {

	public static void main(String[] args) {
		System.out.println("For test");

	}
	public static void testUpdate() {
		VrCustomerDao vrCustomerDao = new VrCustomerDao();
		VrCustomer vrCustomer = vrCustomerDao.findById(1);
		vrCustomer.setRealName("tqq");
		vrCustomerDao.update(vrCustomer);
	}
	public static void testfindpage() {
		VrVenueDao vrVenueDao=new VrVenueDao();
		List<VrVenue> allList=vrVenueDao.findPageByAddress("a", 6, 1);
		Iterator<VrVenue> iterator=allList.iterator();
		while(iterator.hasNext()) {
			VrVenue v=iterator.next();
			System.out.println(v.getVenueName());
		}
	}
	public static void testFindAll() {
		VrVenueDao vrVenueDao=new VrVenueDao();
		List<VrVenue> allList=vrVenueDao.findAll();
		Iterator<VrVenue> iterator=allList.iterator();
		while(iterator.hasNext()) {
			VrVenue v=iterator.next();
			System.out.println(v.getVenueName());
		}
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
