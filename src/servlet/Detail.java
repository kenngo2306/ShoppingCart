package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Shopproduct;
import db.DBLineItem;
import db.DBProduct;

/**
 * Servlet implementation class Detail
 */
@WebServlet("/Detail")
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doget in detail");
		
		//should have validated it first
		long productId = Long.parseLong(request.getParameter("productId").toString());
		
		Shopproduct product = DBProduct.getProduct(productId);
		String productData = "<div class='panel panel-info col-sm-6 col-sm-offset-3'>";
		productData += "<p>";
		productData += product.getProductName();
		productData += "</p>";
		productData += "<p>";
		productData += product.getProductDescription();
		productData += "/<p>";
		productData += "<p>";
		productData += product.getProductType();
		productData += "</p>";
		productData += "<p>";
		productData += product.getPrice();
		productData += "</p>";
		productData += "<img src='"+ product.getImageLink() +"' class='img-rounded' width='304' height='236'/>";
		productData += "</div>";
		
		request.setAttribute("productData", productData);
		long numItems = DBLineItem.getCount();
		HttpSession session = request.getSession();
		session.setAttribute("numItems", numItems);
		getServletContext().getRequestDispatcher("/Detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
