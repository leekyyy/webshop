package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserInfo;

@WebServlet("/uis")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page");
		String sid = (String) request.getSession().getAttribute("sid");
		int curPage=1;
		if(page!=null && page.length()>0){
			curPage=Integer.parseInt(page);		
		}
		UserInfo ui=new UserInfo();
		request.setAttribute("pageBean",ui.getUserList(curPage,sid));
		request.getRequestDispatcher("merchandise/merchandise.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
