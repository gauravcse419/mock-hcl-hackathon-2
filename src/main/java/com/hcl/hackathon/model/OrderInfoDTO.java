package com.hcl.hackathon.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the order_info database table.
 * 
 */

@Data
public class OrderInfoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "order Id",
			example = "1", required = false)
	private Integer orderId;

	@Schema(description = "order No",
			example = "ORD123445555", required = false)
	private String orderNo;

	@Schema(description = "order status",
			example = "Order", required = false)
	private String orderStatus;

	@Schema(description = "total Amount",
			example = "100.9", required = false)
	private Double totalAmount;

	@Schema(description = "user Id",
			example = "user Id", required = false)
	private Integer userId;

	@Schema(description = "order Items")
	private List<OrderItemDTO> orderItems;


}