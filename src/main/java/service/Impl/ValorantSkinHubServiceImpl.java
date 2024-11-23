package service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Model.ValorantAPIResponseInfo;
import entity.Model.ValorantBundleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service.ValorantSkinHubService;

import java.util.List;

@Service
public class ValorantSkinHubServiceImpl implements ValorantSkinHubService {

    //JPARepo not yet configured;
    @Autowired
    private RestTemplate restTemplate;

    public List<ValorantBundleInfo> callExternalApi() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        String url = "https://valorant-api.com/v1/bundles";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        var responseBody = response.getBody();

        ValorantAPIResponseInfo ApiResponseData = mapper.readValue(responseBody, ValorantAPIResponseInfo.class);

        //must convert the data from ApiResponse to List ValorantBundleInfo
    }


}
