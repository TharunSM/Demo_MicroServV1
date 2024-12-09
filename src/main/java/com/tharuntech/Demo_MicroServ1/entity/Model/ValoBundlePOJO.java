package com.tharuntech.Demo_MicroServ1.entity.Model;

import lombok.Data;

@Data
public class ValoBundlePOJO {
    private String uuid;
    private String BundleName;

    private String iconVert;
    private String iconHori;

    private Integer rating;
    private String BundleAvail;

    private Integer price;
    private String currencyType;

    private Integer rateing;
    private Integer rateingCount;
}
