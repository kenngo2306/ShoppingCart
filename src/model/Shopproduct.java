package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the SHOPPRODUCT database table.
 * 
 */
@Entity
@Table(name="SHOPPRODUCT", schema="TESTDB")
@NamedQuery(name="Shopproduct.findAll", query="SELECT s FROM Shopproduct s")
public class Shopproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SHOPPRODUCT_PRODUCTID_GENERATOR", sequenceName="SEQ_SHOPPRODUCT" , schema="TESTDB", allocationSize = 1, initialValue = 11)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHOPPRODUCT_PRODUCTID_GENERATOR")
	@Column(name="PRODUCT_ID")
	private long productId;

	@Column(name="IMAGE_LINK")
	private String imageLink;

	private double price;

	@Column(name="PRODUCT_DESCRIPTION")
	private String productDescription;

	@Column(name="PRODUCT_NAME")
	private String productName;

	@Column(name="PRODUCT_TYPE")
	private String productType;
	
	//bi-directional many-to-one association to Shopuser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private Shopuser shopuser;
	
	@Column(name="AVAILABLE")
	private String available;
	
	@Column(name="SHIPPINGCOST")
	private double shippingcost;
	
	

	public Shopuser getShopuser() {
		return shopuser;
	}

	public void setShopuser(Shopuser shopuser) {
		this.shopuser = shopuser;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public double getShippingcost() {
		return shippingcost;
	}

	public void setShippingcost(double shippingcost) {
		this.shippingcost = shippingcost;
	}

	//bi-directional many-to-one association to Shoplineitem
	@OneToMany(mappedBy="shopproduct")
	private List<Shoplineitem> shoplineitems;

	//bi-directional many-to-one association to Shopreview
	@OneToMany(mappedBy="shopproduct")
	private List<Shopreview> shopreviews;

	public Shopproduct() {
	}

	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getImageLink() {
		return this.imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public List<Shoplineitem> getShoplineitems() {
		return this.shoplineitems;
	}

	public void setShoplineitems(List<Shoplineitem> shoplineitems) {
		this.shoplineitems = shoplineitems;
	}

	public Shoplineitem addShoplineitem(Shoplineitem shoplineitem) {
		getShoplineitems().add(shoplineitem);
		shoplineitem.setShopproduct(this);

		return shoplineitem;
	}

	public Shoplineitem removeShoplineitem(Shoplineitem shoplineitem) {
		getShoplineitems().remove(shoplineitem);
		shoplineitem.setShopproduct(null);

		return shoplineitem;
	}

	public List<Shopreview> getShopreviews() {
		return this.shopreviews;
	}

	public void setShopreviews(List<Shopreview> shopreviews) {
		this.shopreviews = shopreviews;
	}

	public Shopreview addShopreview(Shopreview shopreview) {
		getShopreviews().add(shopreview);
		shopreview.setShopproduct(this);

		return shopreview;
	}

	public Shopreview removeShopreview(Shopreview shopreview) {
		getShopreviews().remove(shopreview);
		shopreview.setShopproduct(null);

		return shopreview;
	}
	
	public double getAvgRating()
	{
		try
		{
			List<Shopreview> reviews = getShopreviews();
			double totalStars = 0;
			for(Shopreview review : reviews)
			{
				totalStars += review.getStars();
			}
			double average = totalStars / reviews.size();
			return average;
		}
		catch(Exception e)
		{
			return 0;
		}

	}

}