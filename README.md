# ShoppingCart

Evil Bank and Gulp have teamed up to create an online store.

Your job is to find ten products for them to sell. Then create a database for those products. Next, create a dynamic web application using JPA to serve as a shopping cart for the Evil-Gulp store.

Your application should allow the user to view a list of products (pictures are optional) and select a product to add to the shopping cart.

Each product should contain a name, description and price and any other information you want to add. The products must be stored in the database.

The user should be able to browse the list, see product details and add the product. Then the user can go back to the list or can go to the cart to checkout.

So, you should have the following pages:

Product List Page
Product Details Page
Shopping Cart Page that shows all the items in the shopping cart
Order Confirmation  that shows the total amount of the items ordered
 

The order confirmation page should display a summary of the order.

------------Part 2----- (BigShopping Branch)
This assignment builds on the completed shopping cart application. You should be using JPA and JSTL for this project. You will be creating users, including the Admin user, adding regular users, making your application follow the principles of Model View Controller (MVC) and displaying a nice user interface.

Add the following features:

Save the shopping cart to the database. The user should be able to come back and add items to the cart again.
Allow for multiple users. Each user should only see the items in their shopping cart.
Your application shall allow a new (non-admin) user to register for your site.
Only registered users can place an order however any user can view products.
Create an admin user that can see all orders that have been placed.
Modify your servlet such that the doGet and doPost only call another method, doProcess which does all the work of the servlet. DoProcess should pass as much code as possible to other classes.
Use the JSTL to display the cart or orders to the JSP pages  you create. Use the foreach tag to loop through and display your cart. 
You cart must contain a line that says: "You have 1 item in your cart" The 1 should reflect the number of items in the cart  and if there are multiple items then the word items must be plural. Use the JSTL if statement or choose construct to make this work.
Charge the user a 6% tax. Show the tax on the order confirmation page but not the shopping cart page.
Allow users to post comments or reviews on the product details page. You must include at least three comments for one product and add comments to three or products. Comments shall include the user's name and date and the number of stars. Search Google images for "Review Stars" or simply use Asterisks.
Make your JSP smaller by including a header and a footer in every page. You can create the header/footer in a separate JSP page and include it in every page with the following code:
<jsp:include page="includes/header.jsp"/>
<jsp:include page="includes/footer.jsp"/>
Use Bootstrap to make your page look nice and contain a navigational bar. Bootstrap should also validate the user's email address and other information that the user enters. 

----------------Part 3--------- (Other branches but master)
The shopping cart applications are looking great! Now let's add some new features.

Once you complete the Super Shopping Cart then post it to GitHub.

Now, create a branch in Eclipse to work on the next set of features. As you finish a feature then merge the branch with the Master branch and commit your project. This way each feature is its own branch and doesn't break the master branch. Only merge to master that which is tested and works.

What to do...

Create a branch called AcceptPayment. Then add a feature where the user can pay with a credit card and can have a shipping address and a billing address. Payments and addresses should be tracked in the database as well.
Create a branch called StoreCredit. Then add a feature where the administrator can issue a credit to a user. For example, the administrator should be able to issue a $25.00 credit to a particular user. When that user purchases something then that user should get he $25.00 credit automatically applied to their order. So their payment amount would be discounted by the $25.00.
Create a branch called ViewPastOrders. Then add a feature where the user can... um, ... view past orders.