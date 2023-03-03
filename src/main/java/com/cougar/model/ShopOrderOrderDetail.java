package com.cougar.model;


import com.cougar.entity.OrderDetail;
import com.cougar.entity.ShopOrder;

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
