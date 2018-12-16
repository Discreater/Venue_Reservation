package test;

import java.util.Iterator;
import java.util.List;

import db.acess.VrVenueDao;
import db.model.VrVenue;

public class Test2 {

	public static void main(String[] args) {
		

	}
	private static void testFindAll() {
		VrVenueDao vrVenueDao=new VrVenueDao();
		List<VrVenue> allList=vrVenueDao.findAll();
		Iterator<VrVenue> iterator=allList.iterator();
		while(iterator.hasNext()) {
			VrVenue v=iterator.next();
			System.out.println(v.getVenueName());
		}
	}
}
