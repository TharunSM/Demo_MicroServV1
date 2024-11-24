package com.tharuntech.Demo_MicroServ1.entity.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class ValorantAPIResponseInfo {

    private List<ValorantBundleInfo> data;

    @JsonIgnore
    private String status;

}
