/**
 * the model of an order in the database
 * annotated for Object-Relational Mapping
 */

package com.stevenlesoft.webstore.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="`ORDER`")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	@NotEmpty
	private String purchaserUsername;
	
	@Column(nullable = false)
	@NotNull
	private long productId;
	
	@Column(nullable = false)
	@NotNull
	private int quantity;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date date;

	public Order(long id, String purchaserUsername, long productId, int quantity, Date date) {
		super();
		this.id = id;
		this.purchaserUsername = purchaserUsername;
		this.productId = productId;
		this.quantity = quantity;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPurchaserUsername() {
		return purchaserUsername;
	}

	public void setPurchaserUsername(String purchaserUsername) {
		this.purchaserUsername = purchaserUsername;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", purchaserUsername=" + purchaserUsername + ", productId=" + productId
				+ ", quantity=" + quantity + ", date=" + date + "]";
	}
	
	
	
}
