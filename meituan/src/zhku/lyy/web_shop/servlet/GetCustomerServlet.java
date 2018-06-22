package zhku.lyy.web_shop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import zhku.lyy.web_shop.entity.Customer;
import zhku.lyy.web_shop.service.UserService;

/**
 * 
 * 获得单个customer对象，并进行操作
 */
@WebServlet("/GetCustomerServlet")
public class GetCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Customer tempC = new Customer();
	private Customer ResultC = new Customer();
	private UserService us = new UserService();

	public GetCustomerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String index = request.getParameter("cindex");
		try {
			String encoding = request.getParameter("encoding");
			if (encoding.equals("ISO-8859-1")) {
				index = new String(index.trim().getBytes("ISO-8859-1"), "UTF-8"); // 解决url获取中文乱码问题
			}
		} catch (Exception e) {
			// 由于跳转过来的编码方式不确定，可能出现encoding无值
		}
		if (index != "" && index != null) {
			// 判断index是姓名还是手机号码
			boolean flag = false;
			for (int i = 0; i < index.length(); i++) {
				flag = Character.isDigit(index.charAt(i));
				if (!flag) {
					break;
				}
			}
			if (!flag) {
				tempC.setUsername(index);
			} else {
				tempC.setUsername(index);
			}
			// 取出customer返回给jsp
			ResultC = us.getCustomer(tempC);
			if (ResultC!=null) {
				//System.out.println("111111111111111111111111111");
				request.setAttribute("Customer", ResultC);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("./manager/modifyCustomer.jsp");
				dispatcher.forward(request, response);
			} else {
				//System.out.println("2222222222222222");
				request.setAttribute("result", index);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("./manager/modifyCustomer.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			request.setAttribute("result", index);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("./manager/modifyCustomer.jsp");
			dispatcher.forward(request, response);
		}

	}
}
