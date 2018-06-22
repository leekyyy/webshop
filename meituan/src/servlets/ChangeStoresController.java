package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import service.ChangeStoresService;

/**
 * Servlet implementation class ChangeStoresController
 */
@WebServlet("/ChangeStoresController")
public class ChangeStoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStoresController() {
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
		ChangeStoresService cs = new ChangeStoresService();
		ArrayList<Map<String, String>> storesMessage=(ArrayList<Map<String, String>>) cs.changeStores(sid);
		JSONArray o = JSONArray.fromObject(storesMessage);
		if(storesMessage != null){
			response.getWriter().print(o);
		}
	}

}
