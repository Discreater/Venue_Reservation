package servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import common.Convert;
import db.acess.VrVenueDao;
import db.model.VrVenue;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String idString = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.valueOf(idString);
		} catch (Exception e) {
			id = 0;
			try {
				Convert.alertAndJump(out, "请求参数非法!", "/Venue_Reservation/index.jsp");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return;
		}
		String name = request.getParameter("name");
		String ownerName = request.getParameter("owner_name");
		String ownerEmail = request.getParameter("owner_email");
		String ownerPhone = request.getParameter("owner_phone");
		String ownerAddress = request.getParameter("owner_address");
		String imgPath = null;
		String address = request.getParameter("address");
		String info = request.getParameter("info");
		String state = request.getParameter("state");
		if (name == null || (name != null && "null".equals(name)) || ownerName == null
				|| (ownerName != null && "null".equals(ownerName)) || ownerEmail == null
				|| (ownerEmail != null && "null".equals(ownerEmail)) || state == null
				|| (state != null && !state.equals("valid") && !state.equals("invalid"))) {
			try {
				Convert.alertAndJump(out, "请求参数非法!", "/Venue_Reservation/index.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		} else {
			try {
				VrVenue venue = null;
				VrVenueDao vrVenueDao = new VrVenueDao();
				if (vrVenueDao.findByName(name) != null && id == -1) {
					Convert.alertAndBack(out, "场馆名称已存在!", 1);
					return;
				} else {
					if (id == -1) {
						venue = new VrVenue();
					} else {
						venue = vrVenueDao.findById(id);
						if (venue == null) {
							Convert.alertAndJump(out, "请求参数非法!", "/Venue_Reservation/index.jsp");
							return;
						}
					}
					
					String extName = "jpg,jpeg,png,gif";
					Part filePart = request.getPart("img");

					String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
					InputStream fileContent = filePart.getInputStream();
					String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
					if(!extName.contains(fileExt)) {
						Convert.alertAndBack(out, "请上传正确格式的图片", 1);
						return;
					}
					String url = "C:\\apache-tomcat-9.0.12\\webapps\\Venue_Reservation_upload\\venue_" + String.format("%04d", id) + "." + fileExt;
					File file = new File(url);
					if(!file.exists()) {
						file.createNewFile();
					}

					FileOutputStream fileOutputStream = new FileOutputStream(url);
					byte[] b = new byte[1024];
					int length;
					while((length= fileContent.read(b))>0){
					fileOutputStream.write(b,0,length);
					}
					fileContent.close();
					fileOutputStream .close();
					imgPath = "/Venue_Reservation_upload/venue_" + String.format("%04d", id) + "." + fileExt;
					
					venue.setVenueName(name);
					venue.setVenueOwnerName(ownerName);
					venue.setVenueOwnerPhone("null".equals(ownerPhone) ? null : ownerPhone);
					venue.setVenueOwnerEmail(ownerEmail);
					venue.setVenueOwnerAddress("null".equals(ownerAddress) ? null : ownerAddress);
					venue.setVenuePicture("null".equals(imgPath) ? null : imgPath);
					venue.setVenueAddress("null".equals(address) ? null : address);
					venue.setVenueInfo("null".equals(info) ? "" : info);
					venue.setVenueState(state);
					if (id == -1) {
						vrVenueDao.insert(venue);
						//	System.err.print(venue.getVenueOwnerEmail());
						venue = vrVenueDao.findByName(name);
						//	System.err.print(venue.getVenueOwnerEmail());
					}
					vrVenueDao.update(venue);
					Convert.alertAndJump(out, "提交成功！",
							"/Venue_Reservation/user_room/admin/venue_manage.jsp?search=&type=name");

				}
			} catch (Exception e) {
				System.err.println(e);
				Convert.alertAndJump(out, "请求参数非法!", "/Venue_Reservation/index.jsp");
			}
		}
	}

}
