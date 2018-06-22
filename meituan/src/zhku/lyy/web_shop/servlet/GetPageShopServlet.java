package zhku.lyy.web_shop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhku.lyy.web_shop.dao.StoreDao;
import zhku.lyy.web_shop.entity.Store;

@WebServlet("/GetPageShopServlet")
public class GetPageShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetPageShopServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StoreDao sd = new StoreDao();
		List<Store> list = sd.getStoreList();
		
		request.setAttribute("storeList",list);
		RequestDispatcher dispatcher = request
						.getRequestDispatcher("./manager/storeList.jsp");
				dispatcher.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
