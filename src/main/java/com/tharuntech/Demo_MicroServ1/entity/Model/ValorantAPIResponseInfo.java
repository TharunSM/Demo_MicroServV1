package com.tharuntech.Demo_MicroServ1.entity.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValorantAPIResponseInfo {

    //all the info of the ValorantApi called is stored here
    private List<ValorantBundleInfo> data;

    @JsonIgnore
    private String status;

}
