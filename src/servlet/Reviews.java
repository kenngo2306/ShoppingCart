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
import model.Shopreview;
import model.Shopuser;
import db.DBProduct;
import db.DBReview;

/**
 * Servlet implementation class Reviews
 */
@WebServlet("/Reviews")
public class Reviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reviews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productIdStr = request.getParameter("productId");
		
		long productId = Long.parseLong(productIdStr);
		
		Shopproduct product = DBProduct.getProduct(productId);
		
		request.setAttribute("product", product);
		getServletContext().getRequestDispatcher("/Reviews.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String content = request.getParameter("content");
		String starsStr = request.getParameter("stars");
		String productIdStr = request.getParameter("productId");
		
		
		int stars = Integer.parseInt(starsStr);
		
		int productId = Integer.parseInt(productIdStr);
		Shopproduct product = DBProduct.getProduct(productId);
		
		HttpSession session = request.getSession();
		Shopuser user = (Shopuser) session.getAttribute("user");
		
		Shopreview review = new Shopreview();
		review.setReviewContent(content);
		review.setShopproduct(product);
		review.setShopuser(user);
		review.setStars(stars);
		
		DBReview.insert(review);
		getServletContext().getRequestDispatcher("/Reviews?productId="+productId+".jsp").forward(request, response);
	}

}
