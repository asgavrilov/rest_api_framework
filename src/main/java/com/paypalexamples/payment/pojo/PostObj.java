package com.paypalexamples.payment.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PostObj {
    private String intent;
    private List<Transactions> transactions;
    private String note_to_payer;
    private Payer payer;
    private Redirect_urls redirect_urls;


}
