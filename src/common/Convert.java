package common;

import java.sql.Timestamp;
import java.util.Date;

public class Convert {
	public static Timestamp dateToTimestamp(Date date) {
		return new Timestamp(Timestamp.parse(date.toString()));
	}
	public static Timestamp dateToTimestamp(java.sql.Date date) {
		return new Timestamp(Timestamp.parse(date.toString()));
	}
}
