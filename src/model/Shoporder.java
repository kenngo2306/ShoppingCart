package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SHOPORDER database table.
 * 
 */
@Entity
@Table(name="SHOPORDER", schema="TESTDB")
@NamedQuery(name="Shoporder.findAll", query="SELECT s FROM Shoporder s")
public class Shoporder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SHOPORDER_ORDERID_GENERATOR", sequenceName="SEQ_SHOPORDER" , schema="TESTDB", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHOPORDER_ORDERID_GENERATOR")
	@Column(name="ORDER_ID")
	private long orderId;

	@Temporal(TemporalType.DATE)
	@Column(name="ORDER_DATE")
	private Date orderDate;

	@Column(name="ORDER_STATUS")
	private String orderStatus;

	@Column(name="ORDER_TOTAL")
	private double orderTotal;
	
	@Column(name="CREDIT_CARD")
	private String creditCard;
	
	@Column(name="BILLING_ADDRESS")
	private String billingAddress;
	
	@Column(name="SHIPPING_ADDRESS")
	private String shippingAddress;
	
	

	public String getCreditCard()
	{
		return creditCard;
	}

	public void setCreditCard(String creditCard)
	{
		this.creditCard = creditCard;
	}

	public String getBillingAddress()
	{
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress)
	{
		this.billingAddress = billingAddress;
	}

	public String getShippingAddress()
	{
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}

	//bi-directional many-to-one association to Shoplineitem
	@OneToMany(mappedBy="shoporder")
	private List<Shoplineitem> shoplineitems;
	

	//bi-directional many-to-one association to Shopuser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private Shopuser shopuser;

	public Shoporder() {
	}

	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getOrderTotal() {
		return this.orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public List<Shoplineitem> getShoplineitems() {
		return this.shoplineitems;
	}

	public void setShoplineitems(List<Shoplineitem> shoplineitems) {
		this.shoplineitems = shoplineitems;
	}

	public Shoplineitem addShoplineitem(Shoplineitem shoplineitem) {
		getShoplineitems().add(shoplineitem);
		shoplineitem.setShoporder(this);

		return shoplineitem;
	}

	public Shoplineitem removeShoplineitem(Shoplineitem shoplineitem) {
		getShoplineitems().remove(shoplineitem);
		shoplineitem.setShoporder(null);

		return shoplineitem;
	}

	public Shopuser getShopuser() {
		return this.shopuser;
	}

	public void setShopuser(Shopuser shopuser) {
		this.shopuser = shopuser;
	}
	
	public double getSubtotal()
	{
		List<Shoplineitem> lineItems = getShoplineitems();
		double total = 0;
		for(Shoplineitem lineItem : lineItems)
		{
			total = total + (lineItem.getQuantity() * lineItem.getShopproduct().getPrice());
		}
		
		return total;
	}
	
	public String getFormattedSubtotal()
	{
		return String.format("%.2f", getSubtotal());
	}
	
	public String getFormattedTax()
	{
		return String.format("%.2f", getTax());
	}
	
	public String getFormattedTotal()
	{
		return String.format("%.2f", getTotal());
	}
	
	public double getTax()
	{
		return getSubtotal() * 0.06;
	}
	
	public double getTotal()
	{
		return getSubtotal() + getTax();
	}
	
	public double getPaymentDue()
	{
		if(getTotal() <= getShopuser().getStoreCredit())
		{
			return 0;
		}
		else
		{
			return getTotal() - getShopuser().getStoreCredit();
		}
	}

}