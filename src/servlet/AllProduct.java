package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Shopproduct;
import model.Shopuser;
import db.DBLineItem;
import db.DBProduct;

/**
 * Servlet implementation class AllProduct
 */
@WebServlet("/AllProduct")
public class AllProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doget");
		
		List<Shopproduct> products = DBProduct.getAllProducts();
//		String productData = "<table class='table table-bordered table-striped'>";
//		productData += "<thead>";
//		productData += "<tr>";
//		productData += "<th>";
//		productData +=  "Product Name";
//		productData += "</th>";
//		productData += "<th>";
//		productData += "Description";
//		productData += "</th>";
//		productData += "<th>";
//		productData += "Price";
//		productData += "</th>";
//		productData += "<th>";
//		productData += "Action";
//		productData += "</th>";
//
//		productData += "</tr>";
//		productData += "</thead>";
//		for(Shopproduct product : products)
//		{
//			
//			productData += "<tr>";
//				productData += "<td>";
//				productData +=  product.getProductName();
//				productData += "</td>";
//				productData += "<td>";
//				productData += product.getProductDescription();
//				productData += "</td>";
//				productData += "<td>";
//				productData += product.getPrice();
//				productData += "</td>";
//				productData += "<td>";
//				productData += "<a class='btn btn-info glyphicon glyphicon-eye-open' href='/ShoppingCart/Detail?productId=" + product.getProductId() +"'> View</a>  ";
//				productData += "<a class='btn btn-primary glyphicon glyphicon-plus' href='/ShoppingCart/AddToCart?productId=" + product.getProductId() +"'> Add</a>";
//				productData += "</td>";
//			productData += "</tr>";
//		}
//		productData += "</table>";
		//request.setAttribute("products", products);
//		long numItems = DBLineItem.getCount();
		
		
		String search = request.getParameter("search");
		System.out.println("search = " + search);
		if(search != null)
		{
			if(!search.isEmpty())
			{
				System.out.println("Searching for " + search);
				Util<Shopproduct> db = new Util<Shopproduct>();
				String qString = "SELECT p FROM Shopproduct p where p.productName like '%" + search +"%'";
				products = db.getList(qString);
			}
		}
		
		
		request.setAttribute("products", products);
		
		getServletContext().getRequestDispatcher("/ProductList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
