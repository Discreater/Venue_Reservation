package test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.annotation.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import db.acess.VrVenueDao;
import db.model.VrOrder;
import db.model.VrVenue;
import junit.*;
import org.junit.Test;
import common.*;

public class Test2 {

	public static void main(String[] args) {

	}

	private static void testFindAll() {
		VrVenueDao vrVenueDao = new VrVenueDao();
		List<VrVenue> allList = vrVenueDao.findAll();
		Iterator<VrVenue> iterator = allList.iterator();
		while (iterator.hasNext()) {
			VrVenue v = iterator.next();
			System.out.println(v.getVenueName());
		}
	}

	@Test
	public void testConvertTimeStampConflict() throws Exception {
		VrOrder aOrder = new VrOrder(), bOrder = new VrOrder();
		aOrder.setUseStartTime(new Timestamp(System.currentTimeMillis()));
		Thread.sleep(1);
		aOrder.setUseEndTime(new Timestamp(System.currentTimeMillis()));
		Thread.sleep(1);
		bOrder.setUseStartTime(new Timestamp(System.currentTimeMillis()));
		Thread.sleep(1);
		bOrder.setUseEndTime(new Timestamp(System.currentTimeMillis()));
		
		assertEquals(false, Convert.orderTimeConflict(aOrder, bOrder));
		
		aOrder.setUseStartTime(new Timestamp(System.currentTimeMillis()));
		Thread.sleep(1);
		bOrder.setUseStartTime(new Timestamp(System.currentTimeMillis()));
		Thread.sleep(1);
		aOrder.setUseEndTime(new Timestamp(System.currentTimeMillis()));
		Thread.sleep(1);
		bOrder.setUseEndTime(new Timestamp(System.currentTimeMillis()));

		assertEquals(true, Convert.orderTimeConflict(aOrder, bOrder));
		assertEquals(true, Convert.orderTimeConflict(bOrder, aOrder));
		assertEquals(true, Convert.orderTimeConflict(aOrder, aOrder));
	}
	@Test
	public void testConvertDateToTimestamp() {
		long nowMs=System.currentTimeMillis();
		Timestamp timestamp=new Timestamp(nowMs);
		Date date=new Date(nowMs);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String convertedStr=Convert.dateToTimestamp(date).toString();
		assertEquals(convertedStr,timestamp.toString());
		assertEquals(convertedStr.substring(0, 18),simpleDateFormat.format(date).substring(0, 18));
	}
}
