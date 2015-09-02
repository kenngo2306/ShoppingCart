package model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the SHOPLINEITEM database table.
 * 
 */
@Entity
@Table(name="SHOPLINEITEM", schema="TESTDB")
@NamedQuery(name="Shoplineitem.findAll", query="SELECT s FROM Shoplineitem s")
public class Shoplineitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SHOPLINEITEM_LINEITEMID_GENERATOR", sequenceName="SEQ_SHOPLINEITEM" , schema="TESTDB", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHOPLINEITEM_LINEITEMID_GENERATOR")
	@Column(name="LINE_ITEM_ID")
	private long lineItemId;

	private double quantity;

	//bi-directional many-to-one association to Shopproduct
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Shopproduct shopproduct;

	//bi-directional many-to-one association to Shoporder
	@ManyToOne
	@JoinColumn(name="ORDER_ID")
	private Shoporder shoporder;

	public Shoplineitem() {
	}

	public long getLineItemId() {
		return this.lineItemId;
	}

	public void setLineItemId(long lineItemId) {
		this.lineItemId = lineItemId;
	}

	public double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Shopproduct getShopproduct() {
		return this.shopproduct;
	}

	public void setShopproduct(Shopproduct shopproduct) {
		this.shopproduct = shopproduct;
	}

	public Shoporder getShoporder() {
		return this.shoporder;
	}

	public void setShoporder(Shoporder shoporder) {
		this.shoporder = shoporder;
	}
	
	public double getLineTotal()
	{
		return getShopproduct().getPrice() * getQuantity();
	}

}