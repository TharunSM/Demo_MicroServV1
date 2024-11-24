package com.tharuntech.Demo_MicroServ1.controller;

import com.tharuntech.Demo_MicroServ1.service.ValorantSkinHubGetAllInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MicroServV1TestOnline {

    @Autowired
    private ValorantSkinHubGetAllInfoService valoServ;

    @GetMapping("/v1/healthcheck")
    public ResponseEntity<String> SeverOnlineCheck(){
        return  ResponseEntity.status(HttpStatus.OK).body("Server v1 working !!");
    }

    @GetMapping("/AddAllBundleToDB")
    public ResponseEntity<String> addAllBundlesToDb(){
        var infoOnAddAllBundles = valoServ.addAllBundlesTodb();
        return ResponseEntity.status(HttpStatus.OK).body("DB Bundle Status = "+infoOnAddAllBundles);
    }


}
