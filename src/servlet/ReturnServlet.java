package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Shoplineitem;
import model.Shoporder;
import model.Shopproduct;
import model.Shopuser;
import db.DBLineItem;
import db.DBOrder;

/**
 * Servlet implementation class ReturnServlet
 */
@WebServlet("/ReturnServlet")
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String table = "";
		HttpSession session = request.getSession();
		Shopuser user = (Shopuser) session.getAttribute("user");
		List<Shoplineitem> lineItems = DBOrder.getAllLineItemsByUserID(user);
		
		
//		List<Shoporder> tmp = DBOrder.getAllOrdersByUserID(user);
//		if(tmp == null){
//			table += "<h3>You don't have any order placed.</h3>";
//		}else{
//			ArrayList<Shoporder> lists = new ArrayList<Shoporder>(tmp);
//			table += "<thead><tr><th>Order ID</th><th>Product Name</th><th>Quantity</th><th>Description</th><th>Image</th><th>Return</th></tr></thead>";
//			for(Shoporder p : lists){
//				int oid = (int) p.getOrderId();
//				List<Shoplineitem> tmp2 = DBLineItem.getLineItemsByOrderID(oid);
//				if(tmp2 != null){
//					ArrayList<Shoplineitem> lists2 = new ArrayList<Shoplineitem>(tmp2);
//					for(Shoplineitem s : lists2){
//						Shopproduct sp = s.getShopproduct();
//						table += "<tr><td><a href = \"ProductDetailServlet?pid=" + sp.getProductId() + "\">" + sp.getProductId() + "</a></td><td>" + sp.getProductName() +"</td><td>" + s.getQuantity() +"</td><td>" + sp.getProductDescription()
//							+ "</td><td><img src=\"" + sp.getImageLink() + "\" alt=\"Product image\" style=\"width: 48px; height: 72px;\"></td><td><a href = \"ConfirmReturnServlet?lineid=" + s.getLineItemId() + "\"><button type=\"button\" class=\"btn pull-left btn-info btn-lg\">Return</button></a></td></tr>\n";
//					}
//				}
//			}	
//			table += "</tbody>" + "</table>" + "</div>";	
//		}
		request.setAttribute("lineItems", lineItems); 
		getServletContext().getRequestDispatcher("/return.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
