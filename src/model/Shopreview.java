package model;

import java.io.Serializable;

import javax.persistence.*;




/**
 * The persistent class for the SHOPREVIEW database table.
 * 
 */
@Entity
@Table(name="SHOPREVIEW", schema="TESTDB")
@NamedQuery(name="Shopreview.findAll", query="SELECT s FROM Shopreview s")
public class Shopreview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SHOPREVIEW_REVIEWID_GENERATOR", sequenceName="SEQ_SHOPREVIEW" , schema="TESTDB", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHOPREVIEW_REVIEWID_GENERATOR")
	@Column(name="REVIEW_ID")
	private long reviewId;

	@Column(name="REVIEW_CONTENT")
	private String reviewContent;

	private int stars;

	//bi-directional many-to-one association to Shopproduct
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Shopproduct shopproduct;

	//bi-directional many-to-one association to Shopuser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private Shopuser shopuser;

	public Shopreview() {
	}

	public long getReviewId() {
		return this.reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviewContent() {
		return this.reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getStars() {
		return this.stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public Shopproduct getShopproduct() {
		return this.shopproduct;
	}

	public void setShopproduct(Shopproduct shopproduct) {
		this.shopproduct = shopproduct;
	}

	public Shopuser getShopuser() {
		return this.shopuser;
	}

	public void setShopuser(Shopuser shopuser) {
		this.shopuser = shopuser;
	}

}