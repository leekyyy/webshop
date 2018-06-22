package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.AddStoresService;

/**
 * Servlet implementation class AddStoresController
 */
@WebServlet("/AddStoresController")
public class AddStoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStoresController() {
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
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String telphone=request.getParameter("telphone");
		String startime=request.getParameter("startime");
		String endtime=request.getParameter("endtime");
		String deliverytime=request.getParameter("deliverytime");
		String deliveryfee=request.getParameter("deliveryfee");
		String uid=(String) request.getSession().getAttribute("uid");
		AddStoresService add=new AddStoresService();
		int result=add.addStores(name, address, telphone, startime, endtime, deliverytime, deliveryfee,uid);
		if(result == 1){
			response.getWriter().print("Ìí¼Ó³É¹¦");
		}
		
		
		
		
	}

}
