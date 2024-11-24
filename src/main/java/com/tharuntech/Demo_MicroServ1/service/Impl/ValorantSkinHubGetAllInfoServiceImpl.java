package com.tharuntech.Demo_MicroServ1.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tharuntech.Demo_MicroServ1.entity.Model.ValorantAPIResponseInfo;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.tharuntech.Demo_MicroServ1.service.ValorantSkinHubGetAllInfoService;



@Service
public class ValorantSkinHubGetAllInfoServiceImpl implements ValorantSkinHubGetAllInfoService {

    //JPARepo not yet configured;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    private final Logger logger = LogManager.getLogger(ValorantSkinHubGetAllInfoServiceImpl.class);

    //make a method to store the data from calling the bellow method and storing it in a db below and call that db in a new method and send the data with our required params
    //https://console.aiven.io/account/a4f7084bd2b9/project/tharunterror9840-0892/services/mysqldb-valoranthub/overview

    //converts the ValorantAPI call to our pojo
    public ValorantAPIResponseInfo callExternalApi(){

        logger.info("--------------ValorantSkinHubGetAllInfoServiceImpl.callExternalApi() -- Service == ---------");

        ObjectMapper mapper = new ObjectMapper();

        String url = "https://valorant-api.com/v1/bundles";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        logger.info("--------------ValorantSkinHubGetAllInfoServiceImpl.callExternalApi() -- Service == VALORANTAPI CALL WORKING---------");
        var responseBody = response.getBody();
        ValorantAPIResponseInfo ApiResponseData = null;
        try {
            ApiResponseData = mapper.readValue(responseBody, ValorantAPIResponseInfo.class);
            logger.info("--------------ValorantSkinHubGetAllInfoServiceImpl.callExternalApi() -- Service == API Converted---------");
            return ApiResponseData;
        }catch (JsonProcessingException e){
            logger.error(e);
        }
        return ApiResponseData;

    }



}
