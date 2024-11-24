package com.tharuntech.Demo_MicroServ1.entity;

import lombok.Data;

@Data
public class ValorantSkinHub {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String uuid;

    private String BundleName;

    private String iconVert;
    private String iconHori;

    private Integer rating;
    private String BundleAvail;

    private Integer price;
    private String currencyType;


}
