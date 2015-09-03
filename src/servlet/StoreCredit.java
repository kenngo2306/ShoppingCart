package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Shopuser;
import db.DBUser;

/**
 * Servlet implementation class StoreCredit
 */
@WebServlet("/StoreCredit")
public class StoreCredit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreCredit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get a list of all user, turn it into a hashmap
		
		//check if login user is an admin (user role = 0)
		HttpSession session = request.getSession();
		
		Shopuser loginUser = (Shopuser)session.getAttribute("user");
		if(loginUser.getUserRole().equals("0"))
		{
			List<Shopuser> users = DBUser.getAllUsers();
			
			request.setAttribute("users", users);
			getServletContext().getRequestDispatcher("/StoreCredit.jsp").forward(request, response);
		}
		else
		{
			getServletContext().getRequestDispatcher("/AllProduct").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userIdStr = request.getParameter("userId");
		String storeCreditStr = request.getParameter("storeCredit" + userIdStr);
		
		System.out.println("userId = " + userIdStr);
		System.out.println("storeCreditStr = " + storeCreditStr);
		
		long userId = Long.parseLong(userIdStr);
		double storeCredit = Double.parseDouble(storeCreditStr);
		Shopuser user = DBUser.getUser(userId);
		user.setStoreCredit(storeCredit);
		System.out.println(user.getEmail());
		System.out.println(user.getFullName());
		System.out.println(user.getStoreCredit());
		System.out.println(user.getUserName());
		System.out.println(user.getUserPassword());
		
		DBUser.update(user);
		
		response.sendRedirect("./StoreCredit");
	}

}
