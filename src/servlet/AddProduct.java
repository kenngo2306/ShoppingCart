package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBProduct;
import model.Shopproduct;
import model.Shopuser;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		Shopuser user = (Shopuser) session.getAttribute("user");
		
		String imageLink = request.getParameter("imageLink");
		String priceStr = request.getParameter("price");
		String productDescription = request.getParameter("productDescription");
		String productName = request.getParameter("productName");
		String productType = request.getParameter("productType");
		String available = request.getParameter("available");
		String shippingcostStr = request.getParameter("shippingcost");
		
		double price = Double.parseDouble(priceStr);
		double shippingcost = Double.parseDouble(shippingcostStr);
		
		Shopproduct product = new Shopproduct();
		product.setImageLink(imageLink);
		product.setPrice(price);
		product.setProductDescription(productDescription);
		product.setProductName(productName);
		product.setProductType(productType);
		product.setAvailable(available);
		product.setShippingcost(shippingcost);
		product.setShopuser(user);
		
		DBProduct.insert(product);
		getServletContext().getRequestDispatcher("/SellingProducts.jsp");
	}

}
