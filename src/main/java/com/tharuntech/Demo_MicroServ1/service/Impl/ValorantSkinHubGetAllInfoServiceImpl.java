package com.tharuntech.Demo_MicroServ1.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tharuntech.Demo_MicroServ1.entity.Model.ValorantAPIResponseInfo;
import com.tharuntech.Demo_MicroServ1.entity.Model.ValorantBundleInfo;
import com.tharuntech.Demo_MicroServ1.entity.ValorantSkinHub;
import com.tharuntech.Demo_MicroServ1.repository.ValoSkinHubRepo;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.tharuntech.Demo_MicroServ1.service.ValorantSkinHubGetAllInfoService;

import java.util.List;
import java.util.Optional;


@Service
public class ValorantSkinHubGetAllInfoServiceImpl implements ValorantSkinHubGetAllInfoService {



    @Value("${valo.BundleInfoApi.url}")
    private String serviceUrl;



    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private ValoSkinHubRepo valoSkinHubRepo;

    private final Logger logger = LogManager.getLogger(ValorantSkinHubGetAllInfoServiceImpl.class);

//    public ValorantSkinHub getAllSkinBundles{
//
//    }




    //add allBundles
    public void addAlltheDataFromExternalApiToOurDB(){
        var allBundleInfo = callExternalApi();
        //parse it to our ValorantSkinHub pojo and add to db
        if(allBundleInfo!=null){
            List<ValorantBundleInfo> allBundlesList = allBundleInfo.getData();
            Integer count =0;
            for(ValorantBundleInfo BundleInfo : allBundlesList){
                //from here iterate and add the data to ur db;
                var uuid = BundleInfo.getUuid();
                var bundleName = BundleInfo.getDisplayName();
                var iconVert = BundleInfo.getVerticalPromoImage();
                var iconHori = BundleInfo.getDisplayIcon();
                var BundleInfoadd = new ValorantSkinHub();
                BundleInfoadd.setUuid(uuid);
                BundleInfoadd.setBundleName(bundleName);
                BundleInfoadd.setIconVert(iconVert);
                BundleInfoadd.setIconHori(iconHori);
                valoSkinHubRepo.save(BundleInfoadd);
                count++;
            }
            logger.info("--------------ValorantSkinHubGetAllInfoServiceImpl.addAlltheDataFromExternalApiToOurDB() -- Service == Added successfull to db---------");
            logger.info("--------------ValorantSkinHubGetAllInfoServiceImpl.addAlltheDataFromExternalApiToOurDB() -- Service == No of Bundles added {}---------",count);

        }else {
            logger.error("--------------ValorantSkinHubGetAllInfoServiceImpl.addAlltheDataFromExternalApiToOurDB() -- Service == No data found in external api call---------");
        }
    }

    //add only the bundle that does not exist
    public void addDataFromExternalApiToOurDBthatNotExist(){

        var allBundleInfo = callExternalApi();

        //parse it to our ValorantSkinHub pojo and add to db
        if(allBundleInfo!=null){
            List<ValorantBundleInfo> allBundlesList = allBundleInfo.getData();
            Integer count =0;
            for(ValorantBundleInfo BundleInfo : allBundlesList){

                //from here iterate and check in our database;
                var uuid = BundleInfo.getUuid();

                //if it exist then we dont add else we add the data
                Optional<String> bundleuuidfromdb = valoSkinHubRepo.existdataByuuid(uuid);
                if(bundleuuidfromdb.isEmpty()){
                    var bundleName = BundleInfo.getDisplayName();
                    var iconVert = BundleInfo.getVerticalPromoImage();
                    var iconHori = BundleInfo.getDisplayIcon();
                    var BundleInfoadd = new ValorantSkinHub();

                    BundleInfoadd.setUuid(uuid);
                    BundleInfoadd.setBundleName(bundleName);
                    BundleInfoadd.setIconVert(iconVert);
                    BundleInfoadd.setIconHori(iconHori);
                    valoSkinHubRepo.save(BundleInfoadd);
                    count++;
                }

            }
            logger.info("--------------ValorantSkinHubGetAllInfoServiceImpl.addDataFromExternalApiToOurDBthatNotExist() -- Service == Added exta successfull to db---------");
            logger.info("--------------ValorantSkinHubGetAllInfoServiceImpl.addDataFromExternalApiToOurDBthatNotExist() -- Service == Updated Bundles added {}---------",count);

        }else {
            logger.error("--------------ValorantSkinHubGetAllInfoServiceImpl.addDataFromExternalApiToOurDBthatNotExist() -- Service == No data found in external api call---------");
        }
    }

    //converts the ValorantAPI call to our pojo
    public ValorantAPIResponseInfo callExternalApi(){

        logger.info("--------------ValorantSkinHubGetAllInfoServiceImpl.callExternalApi() -- Service == ---------");

        ObjectMapper mapper = new ObjectMapper();

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String> response = restTemplate.getForEntity(serviceUrl, String.class);
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

    @Override
    public String addAllBundlesTodb(String value) {
        Optional<ValorantSkinHub> allBundlesGotFromDb = valoSkinHubRepo.findById(1);

        if(value.equalsIgnoreCase("true")){
            addDataFromExternalApiToOurDBthatNotExist();
            return "Force Updated our database with Latest Update";
        }else if(allBundlesGotFromDb.isPresent()){
            return "data already exist in Db";
        }else{
            addAlltheDataFromExternalApiToOurDB();
            return "data Successfully added to our DB";
        }
    }


}
