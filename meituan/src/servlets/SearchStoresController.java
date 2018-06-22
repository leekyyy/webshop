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
import service.SearchStoresService;

/**
 * Servlet implementation class SearchStoresController
 */
@WebServlet("/SearchStoresController")
public class SearchStoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStoresController() {
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
		String searchname=request.getParameter("searchname");
		searchname ="%" +searchname+"%";
		String uid=(String) request.getSession().getAttribute("uid");
		SearchStoresService sc=new SearchStoresService();
		ArrayList<Map<String, String>> searchMessage=(ArrayList<Map<String, String>>) sc.showStores(searchname, uid);
		JSONArray o = JSONArray.fromObject(searchMessage);
		if(o != null){
			response.getWriter().print(o);
		}
	}

}
