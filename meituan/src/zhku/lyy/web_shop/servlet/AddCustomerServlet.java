package zhku.lyy.web_shop.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhku.lyy.web_shop.entity.Customer;
import zhku.lyy.web_shop.service.UserService;
import zhku.lyy.web_shop.utils.UUIDutils;

/**
 * 用于添加客户的相关操作
 */
@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();

	public AddCustomerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// 设置解码方式
		String key = request.getParameter("method");
		if ("checkNameExist".equals(key)) {
			checkNameExist(request, response);
		}
		if ("addCustomer".equals(key)) {
			addCustomer(request, response);
		}
	}

	/*
	 * 
	 * 1. Ajax请求检查用户名是否可用
	 */
	protected void checkNameExist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String customerName = request.getParameter("customerName");
		boolean exist = us.checkNameExist(customerName);
		if (exist) {
			response.getWriter().write("true"); // 存在
		} else {
			response.getWriter().write("flase");// 不存在
		}
	}


	/*
	 * 
	 * 3. 添加客户
	 */
	protected void addCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("CName");
		String password = request.getParameter("CPassword1");
		
		int id = 0;// 获取随机UUID作为客户信息的id
		Customer tempC = new Customer(id, name, password, 0);
		UserService us = new UserService();
		if (us.addCustomer(tempC)) {
			request.setAttribute("message", "添加成功！");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("./manager/addCresult.jsp");
			dispatcher.forward(request, response);
		}
	}

}
