package common;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspWriter;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import db.acess.VrCustomerDao;
import db.model.VrCustomer;
import db.model.VrOrder;

public class Convert {
	private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static Timestamp dateToTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	public static Timestamp urlParamaterToTimestamp(String paramater) throws ParseException {
		String[] s = paramater.split("T");
		Date date = simpleDateFormat.parse(s[0] + " " + s[1]);
		return Convert.dateToTimestamp((simpleDateFormat.parse(s[0] + " " + s[1])));
	}

	public static boolean orderTimeConflict(VrOrder aOrder, VrOrder bOrder) {
		long aStart = aOrder.getUseStartTime().getTime(), bStart = bOrder.getUseStartTime().getTime(),
				aEnd = aOrder.getUseEndTime().getTime(), bEnd = bOrder.getUseEndTime().getTime();
		return (aStart <= bStart && aEnd >= bStart) || (bStart <= aStart && bEnd >= aStart);
	}

	public static void alertAndJump(JspWriter out, String msg, String url) throws Exception {
		out.println("<script type=\"text/javascript\">");
		if (msg != null) {
			out.println("alert(\"" + msg + "\");");
		}
		if (url != null) {
			out.println("window.location.href=\"" + url + "\";");
		}
		out.println("</script>");
	}

	public static void alertAndBack(JspWriter out, String msg, int backPageNumberPositive) throws Exception {
		out.println("<script type=\"text/javascript\">");
		if (msg != null) {
			out.println("alert(\"" + msg + "\");");
		}
		if (backPageNumberPositive > 0) {
			out.println("history.go(" + (-backPageNumberPositive) + ");");
		}
		out.println("</script>");
	}
	public static String vrOrderTimeFromAndTo(VrOrder vrOrder) {
		
		return simpleDateFormat.format(new Date(vrOrder.getUseStartTime().getTime()))
				+ " ~ " +
				simpleDateFormat.format(new Date(vrOrder.getUseEndTime().getTime()));
	}
	public static String CustIdToName(int CustId) {
		System.out.println("calling custIdtoname");
		VrCustomerDao vrCustomerDao=new VrCustomerDao();
		return vrCustomerDao.findById(CustId).getCustName();		
	}
	public static boolean isPoliteComment(String comment) {
		String[] rudeWords= {"sb"};
		comment=comment.toLowerCase();
		for(String aString:rudeWords) {
			if(comment.contains(aString)) {
				return false;
			}
		}
		return true;
	}
	public static String timestampToDateString(Timestamp ts) {
		return simpleDateFormat.format(new Date(ts.getTime()).toString());
	}
}
