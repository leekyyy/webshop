package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.NewOrderService;

/**
 * Servlet implementation class NewOrder
 */
@WebServlet("/NewOrder")
public class NewOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sid = request.getParameter("sid");
		String state = request.getParameter("state");
		System.out.println("BBB"+sid);
		NewOrderService no = new NewOrderService();
		ArrayList<Map<String, String>> newordermessage = (ArrayList<Map<String, String>>) no.newOrder(sid,state);
		request.getSession().setAttribute("neworder", newordermessage);
		request.getRequestDispatcher("order/order.jsp").forward(request, response);
		
	}

}
