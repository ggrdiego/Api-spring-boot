package com.ggrdiego.api_spring_boot.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.ggrdiego.api_spring_boot.entities.Order;
import com.ggrdiego.api_spring_boot.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Embeddable
public class OrderItemPk implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@ManyToMany
	@JoinColumn(name = "order_id")
	private Product product;
	
	@ManyToMany
	@JoinColumn(name = "product_id")
	private Order order;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPk other = (OrderItemPk) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}

}
