package login.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.acess.VrAdminDao;
import db.acess.VrCustomerDao;
import db.model.VrAdmin;
import db.model.VrCustomer;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JoinServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//获取提交数据;
		String username=request.getParameter("username");
		VrCustomer vrCustomer = new VrCustomerDao().findByName(username);
		VrAdmin vrAdmin = new VrAdminDao().findByName(username);
		if(vrCustomer != null || vrAdmin != null){	// 用户名重复
			out.println("<script language=\"javascript\">");
			out.println("alert(\"此用户已经被占用请重新注册\");");
			out.println("history.back();");
			out.println("</script>");
		}else{
			out.println("<script language=\"javascript\">");
			out.println("alert(\"注册成功\");");
			out.println("history.back();");
			out.println("</script>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
