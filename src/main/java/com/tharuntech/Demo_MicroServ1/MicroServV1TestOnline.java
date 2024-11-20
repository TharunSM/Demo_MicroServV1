package com.tharuntech.Demo_MicroServ1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MicroServV1TestOnline {

    @GetMapping("/v1")
    public ResponseEntity<String> SererOnlineCheck(){
        return  ResponseEntity.status(HttpStatus.OK).body("Server v1 working !!");
    }
}
