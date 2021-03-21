package com.paypalexamples.payment.pojo;

import lombok.Data;

@Data
public class Items {
    private String price;
    private String tax;
    private String description;
    private String name;
    private String quantity;
    private String sku;
    private String currency;
}
