package login.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.acess.VrAdminDao;
import db.acess.VrCustomerDao;
import db.model.VrAdmin;
import db.model.VrCustomer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 测试数据
		System.out.println(username + " " + password);
		HttpSession session = null;
		
		VrAdmin vrAdmin = new VrAdminDao().findOne(username, password);
		if (vrAdmin != null) {
			request.setAttribute("info", "管理员登陆成功");
			session = request.getSession();
			session.setAttribute("Admin", vrAdmin);
		} else {
			VrCustomer vrCustomer = new VrCustomerDao().findOne(username, password);
			if (vrCustomer != null) {
				request.setAttribute("info", "客户登录成功");
				session = request.getSession();
				session.setAttribute("Customer", vrCustomer);
			} else {
				request.setAttribute("info", "登录失败");

			}
		}

		request.getRequestDispatcher("/user_act/login_info.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
