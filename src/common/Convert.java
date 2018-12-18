package common;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import db.model.VrOrder;

public class Convert {
	public static Timestamp dateToTimestamp(Date date) {
		return new Timestamp(Timestamp.parse(date.toString()));
	}

	public static Timestamp urlParamaterToTimestamp(String paramater) throws ParseException {
		String[] s = paramater.split("T");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return Convert.dateToTimestamp((simpleDateFormat.parse(s[0] + " " + s[1])));
	}
	public static boolean orderTimeConflict(VrOrder aOrder,VrOrder bOrder) {
		Timestamp aStart=aOrder.getUseStartTime(),
				  bStart=bOrder.getUseStartTime(),
				  aEnd=aOrder.getUseEndTime(),
				  bEnd=bOrder.getUseEndTime();
		return 
				(aStart.before(bStart)&&aEnd.after(bStart)) ||
				(bStart.before(aStart)&&bEnd.after(aStart)) ;
	}
}
