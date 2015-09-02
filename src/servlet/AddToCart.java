package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBLineItem;
import db.DBProduct;
import model.Shoplineitem;
import model.Shoporder;
import model.Shopproduct;
import model.Shopuser;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doget addtoCart");
		String productIdStr = request.getParameter("productId");
		
		long productId = Long.parseLong(productIdStr);
		
		Shopproduct product = DBProduct.getProduct(productId);
		request.setAttribute("product", product);
		getServletContext().getRequestDispatcher("/AddToCart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost");
		
		String quantityStr = request.getParameter("quantity");
		String productIdStr = request.getParameter("productId");
		
		System.out.println(quantityStr + " " + productIdStr);
		double quantity = Double.parseDouble(quantityStr);
		long productId = Long.parseLong(productIdStr);
		
		Shoplineitem lineItem = new Shoplineitem();
		lineItem.setQuantity(quantity);
		lineItem.setShopproduct(DBProduct.getProduct(productId));
		
		//get active order (order/shopping cart with 'OPEN' status)
		HttpSession session = request.getSession();
		Shopuser user = (Shopuser)session.getAttribute("user");
		Shoporder activeOrder = user.getActiveOrder();
		System.out.println("Active order id = " + activeOrder.getOrderId());
		
		//set order id
		lineItem.setShoporder(activeOrder);
		
		DBLineItem.insert(lineItem);
		
		
		getServletContext().getRequestDispatcher("/ShoppingCart").forward(request, response);
	}

}
