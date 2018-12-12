package login.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// 定义输出流
		PrintWriter out = response.getWriter();
		// 获取前端页面输入数据
		String username = request.getParameter("username");
		// 测试打印，测试接收前台数据是否成功
		System.out.println(username);
		// 进行比较并作出响应。
		if (username == null || username.equals("")) {
			out.println("请输入用户名 ");
		} else if ("sa".equals(username)) {
			out.println("该用户名已经存在");
		} else {
			out.println("可以注册");
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
