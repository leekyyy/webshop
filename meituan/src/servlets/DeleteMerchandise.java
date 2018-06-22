package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DeleteMerchandiseServise;

/**
 * Servlet implementation class DeleteMerchandise
 */
@WebServlet("/DeleteMerchandise")
public class DeleteMerchandise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMerchandise() {
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
		String pid = request.getParameter("pid");
		System.out.println("AAA"+pid);
		DeleteMerchandiseServise mm = new DeleteMerchandiseServise();
		int result = mm.delete_merchandise(pid);
		if(result == 1){
			System.out.println("É¾³ý³É¹¦");
			
		}
	}

}
