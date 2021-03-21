package com.paypalexamples.payment.pojo;

import lombok.Data;

@Data
public class Transactions {
    private Amount amount;
    private PaymentOptions paymentOptions;
    private Item_list item_list;

    private String description;
    private String soft_descriptor;
    private String invoice_number;
    private String custom;


}
