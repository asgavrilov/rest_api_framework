package com.paypalexamples.payment.pojo;

import lombok.Data;

@Data
public class Shipping_address {
    private String phone;
    private String postal_code;
    private String state;
    private String line1;
    private String recipient_name;
    private String country_code;
    private String city;
    private String line2;
}
