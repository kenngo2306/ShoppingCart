package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBOrder;
import model.Shoporder;
import model.Shopuser;

/**
 * Servlet implementation class PlaceOrder
 */
@WebServlet("/PlaceOrder")
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get active order
		HttpSession session = request.getSession();
		Shopuser user = (Shopuser)session.getAttribute("user");
		
		Shoporder order = user.getActiveOrder();
		
		Date orderDate = new Date();
		order.setOrderDate(orderDate);
		
		
		order.setOrderTotal(order.getTotal());
		order.setOrderStatus("PLACED");
		
		//save order
		DBOrder.update(order);
		
		
		//create a new blank (with OPEN status) order
		Shoporder newOrder = new Shoporder();
		newOrder.setOrderStatus("OPEN");
		newOrder.setShopuser(user);
		
		//insertt new order into database
		DBOrder.insert(newOrder);
		
		request.setAttribute("order", order);
		getServletContext().getRequestDispatcher("/Confirmation.jsp").forward(request, response);
	}

}
