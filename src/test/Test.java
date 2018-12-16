package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import db.acess.VrAdminDao;
import db.model.VrAdmin;

public class Test {

	public static void main(String[] args) {
		System.out.println("For test");
		testfindVrAdmin();


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
