package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DeliveryOrderService;

/**
 * Servlet implementation class DeliveryOrder
 */
@WebServlet("/DeliveryOrder")
public class DeliveryOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryOrder() {
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
		DeliveryOrderService dd = new DeliveryOrderService();
		String oid = request.getParameter("oid");
		System.out.println("CCC"+oid);
		int result = dd.modify_state(oid);
		if(result == 1){
			System.out.println("接单成功");
			request.getRequestDispatcher("order/order.jsp").forward(request, response);
			
		}
	}

}
