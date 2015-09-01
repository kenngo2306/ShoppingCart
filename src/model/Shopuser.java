package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SHOPUSER database table.
 * 
 */
@Entity
@Table (name="SHOPUSER", schema="TESTDB")
@NamedQuery(name="Shopuser.findAll", query="SELECT s FROM Shopuser s")
public class Shopuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SHOPUSER_USERID_GENERATOR", sequenceName="SEQ_SHOPUSER" , schema="TESTDB", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHOPUSER_USERID_GENERATOR")
	@Column(name="USER_ID")
	private long userId;

	private String email;

	@Column(name="FULL_NAME")
	private String fullName;

	@Column(name="USER_NAME")
	private String userName;

	@Column(name="USER_ROLE")
	private String userRole;

	//bi-directional many-to-one association to Shoporder
	@OneToMany(mappedBy="shopuser")
	private List<Shoporder> shoporders;

	//bi-directional many-to-one association to Shopreview
	@OneToMany(mappedBy="shopuser")
	private List<Shopreview> shopreviews;

	public Shopuser() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public List<Shoporder> getShoporders() {
		return this.shoporders;
	}

	public void setShoporders(List<Shoporder> shoporders) {
		this.shoporders = shoporders;
	}

	public Shoporder addShoporder(Shoporder shoporder) {
		getShoporders().add(shoporder);
		shoporder.setShopuser(this);

		return shoporder;
	}

	public Shoporder removeShoporder(Shoporder shoporder) {
		getShoporders().remove(shoporder);
		shoporder.setShopuser(null);

		return shoporder;
	}

	public List<Shopreview> getShopreviews() {
		return this.shopreviews;
	}

	public void setShopreviews(List<Shopreview> shopreviews) {
		this.shopreviews = shopreviews;
	}

	public Shopreview addShopreview(Shopreview shopreview) {
		getShopreviews().add(shopreview);
		shopreview.setShopuser(this);

		return shopreview;
	}

	public Shopreview removeShopreview(Shopreview shopreview) {
		getShopreviews().remove(shopreview);
		shopreview.setShopuser(null);

		return shopreview;
	}

}