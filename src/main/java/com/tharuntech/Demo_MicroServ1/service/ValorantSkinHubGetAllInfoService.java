package com.tharuntech.Demo_MicroServ1.service;

import com.tharuntech.Demo_MicroServ1.entity.Model.ValorantAPIResponseInfo;
import com.tharuntech.Demo_MicroServ1.entity.ValorantSkinHub;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ValorantSkinHubGetAllInfoService {

    ValorantAPIResponseInfo callExternalApi();

    String addAllBundlesTodb(String value);

    List<ValorantSkinHub> getAllBundels();
}
