package com.tharuntech.Demo_MicroServ1.entity.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BundleRateing {

    @Id
    private String uuid;

    private Integer rateing;

    private Integer rateingCount;


}
