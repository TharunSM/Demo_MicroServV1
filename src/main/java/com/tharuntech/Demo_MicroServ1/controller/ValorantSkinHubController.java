package com.tharuntech.Demo_MicroServ1.controller;

import com.tharuntech.Demo_MicroServ1.entity.Model.ValoBundlePOJO;
import com.tharuntech.Demo_MicroServ1.entity.Model.ValorantAPIResponseInfo;
import com.tharuntech.Demo_MicroServ1.entity.Model.ValorantSkinHub;
import com.tharuntech.Demo_MicroServ1.service.ValorantSkinHubGetAllInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ValorantSkinHubController {

    @Autowired
    private ValorantSkinHubGetAllInfoService valoServ;

    private final Logger logger = LogManager.getLogger(ValorantSkinHubController.class);

    @GetMapping("/v1/getAllInfo")
    public ResponseEntity<List<ValoBundlePOJO>> getAllBundleInfo() {
        logger.info("--------------ValorantSkinHubController.getAllBundleInfo() Inside controller---------");
        return ResponseEntity.status(HttpStatus.OK).body(valoServ.getAllInfo());
    }

    //get all Bundlerecords
    @GetMapping("/v1/getAllSkinBundles")
    public ResponseEntity<List<ValorantSkinHub>> getAllSkinBundlesInfo() {
        logger.info("--------------ValorantSkinHubController.getAllSkinBundlesInfo() Inside controller---------");
        return ResponseEntity.status(HttpStatus.OK).body(valoServ.getAllSkinBundels());
    }

    //to get all unparsed preRecords
    @GetMapping("/v1/getBundlePreRecords")
    public ResponseEntity<ValorantAPIResponseInfo> getAllBundlePreParseInfo() {
        logger.info("--------------ValorantSkinHubController.getAllBundlePreParseInfo() Inside controller---------");
        return ResponseEntity.status(HttpStatus.OK).body(valoServ.callExternalApi());
    }


}
