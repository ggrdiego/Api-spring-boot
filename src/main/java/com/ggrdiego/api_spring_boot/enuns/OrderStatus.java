package com.ggrdiego.api_spring_boot.enuns;

public enum OrderStatus {

	WAITING_PAYMENT(0),
	PAID(1),
	SHIPPED(2),
	DELIVERED(3),
	CANCELED(4);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	

	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOfCodeOrder(int code) {
		
		for(OrderStatus orderStatus: OrderStatus.values()) {
			if(orderStatus.getCode() == code) {
				return orderStatus;
			}
		}throw new IllegalArgumentException("invalid code in OrderStatus!");
		
	}
}
