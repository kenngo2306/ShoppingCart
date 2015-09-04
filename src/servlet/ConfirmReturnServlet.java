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
 * Servlet implementation class ConfirmReturnServlet
 */
@WebServlet("/ConfirmReturnServlet")
public class ConfirmReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmReturnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long lineid = Long.parseLong(request.getParameter("lineid"));
		HttpSession session = request.getSession();
		Shopuser suser = (Shopuser) session.getAttribute("user");
		Shoplineitem item = DBLineItem.getLineItem(lineid);
		item.setReturned("Yes");
		DBLineItem.update(item);
		Shoplineitem newitem = new Shoplineitem();
		
		newitem.setShoporder(item.getShoporder());
		newitem.setShopproduct(item.getShopproduct());
		newitem.setQuantity(0-item.getQuantity());
		newitem.setReturned("Yes");
		DBLineItem.insert(newitem);
		double linetotal = item.getLineTotal();
		suser.setStoreCredit(suser.getStoreCredit() + linetotal);
		DBUser.update(suser);
		session.setAttribute("user", suser);
		getServletContext().getRequestDispatcher("/ReturnServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
