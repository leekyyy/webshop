package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ModifyStoresService;

/**
 * Servlet implementation class ModifyStoresController
 */
@WebServlet("/ModifyStoresController")
public class ModifyStoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyStoresController() {
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
		response.setCharacterEncoding("utf-8");
		String sid = request.getParameter("sid");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String telphone = request.getParameter("telphone");
		String startime = request.getParameter("startime");
		String endtime = request.getParameter("endtime");
		String deliverytime = request.getParameter("deliverytime");
		String deliveryfee = request.getParameter("deliveryfee");
		ModifyStoresService ms = new ModifyStoresService();
		int result = ms.ModifyStores(name, address, telphone, startime, endtime, deliverytime, deliveryfee, sid);
		if(result == 1){
			response.getWriter().print("ÐÞ¸Ä³É¹¦");
		}
	}

}
