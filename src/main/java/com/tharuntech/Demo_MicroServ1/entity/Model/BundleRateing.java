package com.tharuntech.Demo_MicroServ1.entity.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BundleRateing {

    @Id
    private String uuid;

    private Integer rateing;

    private Integer rateingCount;


}
