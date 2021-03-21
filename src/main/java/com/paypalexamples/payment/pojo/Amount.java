package com.paypalexamples.payment.pojo;

import lombok.Data;

@Data
public class Amount {
    private String total;
    private Details details;
    private String currency;

}
