package com.tharuntech.Demo_MicroServ1.service;

import com.tharuntech.Demo_MicroServ1.entity.Model.ValorantAPIResponseInfo;
import org.springframework.stereotype.Service;

@Service
public interface ValorantSkinHubGetAllInfoService {

    ValorantAPIResponseInfo callExternalApi() ;
    String addAllBundlesTodb();
}
