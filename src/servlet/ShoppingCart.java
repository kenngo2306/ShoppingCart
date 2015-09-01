package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Shoplineitem;
import db.DBLineItem;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Shoplineitem> lineItems = DBLineItem.getAllLineItems();
		String lineData = "<table class='table table-bordered table-striped'>";
		lineData += "<thead>";
		lineData += "<tr>";
		lineData += "<th>";
		lineData += "Product Name";
		lineData += "</th>";
		lineData += "<th>";
		lineData += "Price";
		lineData += "</th>";
		lineData += "<th>";
		lineData += "Quantity";
		lineData += "</th>";
		lineData += "<th>";
		lineData += "Line Total";
		lineData += "</th>";
		lineData += "</tr>";
		lineData += "</thead>";
		
		double total = 0;
		for(Shoplineitem lineItem : lineItems)
		{
			lineData += "<tr>";
			lineData += "<td>";
			lineData += lineItem.getShopproduct().getProductName();
			lineData += "</td>";
			lineData += "<td>";
			lineData += lineItem.getShopproduct().getPrice();
			lineData += "</td>";
			lineData += "<td>";
			lineData += lineItem.getQuantity();
			lineData += "</td>";
			lineData += "<td>";
			lineData += lineItem.getLineTotal();
			lineData += "</td>";
			lineData += "</tr>";
			total += lineItem.getLineTotal();
		}
		lineData +="<tr>";
		lineData +="<td colspan='3'>" + "Total" + "</td>";
		lineData +="<td>" + total + "</td>";
		lineData +="</tr>";
		lineData +="</table>";
		request.setAttribute("lineData", lineData);
		long numItems = DBLineItem.getCount();
		HttpSession session = request.getSession();
		session.setAttribute("numItems", numItems);
		getServletContext().getRequestDispatcher("/ShoppingCart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
