package test;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import common.Convert;
import db.acess.VrAdminDao;
import db.acess.VrCommitDao;
import db.acess.VrCustomerDao;
import db.acess.VrOrderDao;
import db.acess.VrVenueDao;
import db.model.VrAdmin;
import db.model.VrCommit;
import db.model.VrCustomer;
import db.model.VrOrder;
import db.model.VrVenue;

public class Test {

	public static void main(String[] args) {
		System.out.println("For test");
		testDeleteCommit(23);
	}
	public static void testUpdateCommit() {
		VrCommitDao  vrCommitDao = new VrCommitDao();

	}
	public static void testDeleteCommit(int i) {
		VrCommitDao  vrCommitDao = new VrCommitDao();
		vrCommitDao.delete(i);
	}
	public static void testInsertCommit() {
		VrCommitDao  vrCommitDao = new VrCommitDao();
		VrCommit vrCommit  = new VrCommit();
		vrCommit.setCommitState("wait");
		vrCommit.setCommitContext("测试_for_test.真的只是用于测试");
		vrCommit.setCommitType("userCommit");
		vrCommit.setCustId(1);
		vrCommitDao.insert(vrCommit);
		System.err.println(vrCommit.getCommitId());
	}
	
	@SuppressWarnings("deprecation")
	private static void testInsertOrder() {
		VrOrderDao vrOrderDao = new VrOrderDao();
		VrOrder vrOrder = new VrOrder();
		
		vrOrder.setOrdDealTime(new Timestamp(110, 1, 1, 1, 1, 1, 0));
		vrOrder.setUseStartTime(new Timestamp(110, 2, 1, 1, 1, 1, 0));
		vrOrder.setUseEndTime(new Timestamp(110, 2, 2, 1, 1, 1, 0));
		vrOrder.setOrdSubmitReason("第二次预约着玩");
		vrOrder.setCustId(2);
		vrOrder.setVenueId(5);
		vrOrderDao.insert(vrOrder);
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
