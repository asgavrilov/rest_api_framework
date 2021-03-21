package com.paypalexamples.payment.pojo;


import lombok.Data;

import java.util.List;

@Data
public class Item_list {
    private Shipping_address shipping_address;
    private List<Items> items;
}
