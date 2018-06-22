package zhku.lyy.web_shop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhku.lyy.web_shop.entity.Customer;
import zhku.lyy.web_shop.service.UserService;
import zhku.lyy.web_shop.utils.UUIDutils;

/**
 * 
 * 修改customer的封装操作
 */
@WebServlet("/ModifyCustomerServlet")
public class ModifyCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModifyCustomerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("Id"));
		String name = request.getParameter("CName");
		String password = request.getParameter("CPassword");
		int uTypeid = Integer.parseInt(request.getParameter("CGender"));
		Customer tempC = new Customer(id, name, password, uTypeid);
		UserService us = new UserService();
		if (us.modifyCustomer(tempC)) {
			request.setAttribute("message", "修改成功!");
			request.setAttribute("ResultCName", tempC.getUsername());
			request.getRequestDispatcher("./manager/modifyCustomerResult.jsp")
					.forward(request, response);
		} else {
			request.setAttribute("message", "修改失败，请尝试重新搜索是否有该用户或者再次尝试。");
			request.setAttribute("ResultCName", tempC.getUsername());
			request.getRequestDispatcher("./manager/modifyCustomerResult.jsp")
					.forward(request, response);
		}
	}

}
