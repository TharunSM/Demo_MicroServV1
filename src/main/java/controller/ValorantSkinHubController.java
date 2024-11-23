package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ValorantSkinHubService;

@RestController
public class ValorantSkinHubController {

    @Autowired
    private ValorantSkinHubService valoServ;


    @GetMapping("/v1")
    public ResponseEntity<String> getAllBundleInfo(){
        ResponseEntity.status(HttpStatus.OK).body(valoServ.getAllBundles());
    }
}
