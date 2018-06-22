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
 * ��õ���customer���󣬲����в���
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
				index = new String(index.trim().getBytes("ISO-8859-1"), "UTF-8"); // ���url��ȡ������������
			}
		} catch (Exception e) {
			// ������ת�����ı��뷽ʽ��ȷ�������ܳ���encoding��ֵ
		}
		if (index != "" && index != null) {
			// �ж�index�����������ֻ�����
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
			// ȡ��customer���ظ�jsp
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
