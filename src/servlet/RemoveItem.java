package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBLineItem;
import db.DBUser;
import model.Shoplineitem;
import model.Shopuser;

/**
 * Servlet implementation class RemoveItem
 */
@WebServlet("/RemoveItem")
public class RemoveItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost in remove item");
		String lineItemIdStr = request.getParameter("lineItemId");
		
		long lineItemId = Long.parseLong(lineItemIdStr);
		
		Shoplineitem lineItem = DBLineItem.getLineItem(lineItemId);
		
		DBLineItem.delete(lineItem);
		
		//reset user object in session variable
		HttpSession session = request.getSession();
		Shopuser user = (Shopuser)session.getAttribute("user");
		Shopuser updatedUser = DBUser.getUser(user.getUserId());
		session.setAttribute("user", updatedUser);
		
		
		getServletContext().getRequestDispatcher("/ShoppingCart").forward(request, response);
	}

}
