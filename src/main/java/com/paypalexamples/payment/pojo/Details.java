package com.paypalexamples.payment.pojo;

import lombok.Data;

@Data
public class Details {
    private String insurance;
    private String shipping;
    private String shipping_discount;
    private String tax;
    private String handling_fee;
    private String subtotal;
}
