package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SHOPLINEITEM database table.
 * 
 */
@Entity
@NamedQuery(name="Shoplineitem.findAll", query="SELECT s FROM Shoplineitem s")
public class Shoplineitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SHOPLINEITEM_LINEITEMID_GENERATOR", sequenceName="SEQ_SHOPLINEITEM")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHOPLINEITEM_LINEITEMID_GENERATOR")
	@Column(name="LINE_ITEM_ID")
	private long lineItemId;

	private BigDecimal quantity;

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

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
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

}