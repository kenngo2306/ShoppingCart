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
import db.DBUser;
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
//		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get credit card and address info
		String creditCard = request.getParameter("creditCard");
		String billingAddress = request.getParameter("billingAddress");
		String shippingAddress = request.getParameter("shippingAddress");
		
		//get active order
		HttpSession session = request.getSession();
		Shopuser tempUser = (Shopuser)session.getAttribute("user");
		
		//refresh user
		Shopuser user = DBUser.getUser(tempUser.getUserId());
		
		Shoporder order = user.getActiveOrder();
		
		Date orderDate = new Date();
		order.setOrderDate(orderDate);
		
		order.setCreditCard(creditCard);
		order.setBillingAddress(billingAddress);
		order.setShippingAddress(shippingAddress);
		
		order.setOrderTotal(order.getTotal());
		order.setOrderStatus("PLACED");
		
		//save order
		DBOrder.update(order);
		
		//update user credit
		double storeCredit = user.getStoreCredit();
		
		if(storeCredit<=0)
		{
			//no credit, do nothing
		}
		else
		{
			//update credit
			if(storeCredit >= order.getOrderTotal())
			{
				user.setStoreCredit(storeCredit - order.getOrderTotal()); 
			}
			else
			{
				user.setStoreCredit(0);
			}
			
			//update user's credit to database:
			DBUser.update(user);
		}
		
		
		//create a new blank (with OPEN status) order
		Shoporder newOrder = new Shoporder();
		newOrder.setOrderStatus("OPEN");
		newOrder.setShopuser(user);
		
		//insertt new order into database
		DBOrder.insert(newOrder);
		
		//reset user object in session variable
		Shopuser updatedUser = DBUser.getUser(user.getUserId());
		
		session.setAttribute("user", updatedUser);
		
		request.setAttribute("order", order);
		getServletContext().getRequestDispatcher("/Confirmation.jsp").forward(request, response);
	}

}
