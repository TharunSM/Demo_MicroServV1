package com.tharuntech.Demo_MicroServ1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ValorantSkinHub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vskinId;

    private String uuid;
    private String BundleName;

    private String iconVert;
    private String iconHori;

    private Integer rating;
    private String BundleAvail;

    private Integer price;
    private String currencyType;


}
