package com.cougar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopOrderOrderDetail {

	ShopOrder shopOrder;
	OrderDetail orderDetail;
}
