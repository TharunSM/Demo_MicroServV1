package com.tharuntech.Demo_MicroServ1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tharuntech.Demo_MicroServ1.entity.Model.ValorantAPIResponseInfo;
import com.tharuntech.Demo_MicroServ1.entity.ValorantSkinHub;
import com.tharuntech.Demo_MicroServ1.service.ValorantSkinHubGetAllInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ValorantSkinHubController {

    @Autowired
    private ValorantSkinHubGetAllInfoService valoServ;

    private final Logger logger = LogManager.getLogger(ValorantSkinHubController.class);

    //get all Bundlerecords
    @GetMapping("/v1/getAllBundles")
    public ResponseEntity<List<ValorantSkinHub>> getAllBundlesInfo() {
        logger.info("--------------ValorantSkinHubController.getAllBundleInfo() Inside controller---------");
        return ResponseEntity.status(HttpStatus.OK).body(valoServ.getAllBundels());
    }


    //to get all unparsed preRecords
    @GetMapping("/v1/getPreRecords")
    public ResponseEntity<ValorantAPIResponseInfo> getAllBundlePreParseInfo() {
        logger.info("--------------ValorantSkinHubController.getAllBundlePreParseInfo() Inside controller---------");
        return ResponseEntity.status(HttpStatus.OK).body(valoServ.callExternalApi());
    }


}
