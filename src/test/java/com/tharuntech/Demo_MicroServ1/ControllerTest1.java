package com.tharuntech.Demo_MicroServ1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tharuntech.Demo_MicroServ1.controller.ValorantSkinHubController;
import com.tharuntech.Demo_MicroServ1.entity.Model.ValoBundlePOJO;
import com.tharuntech.Demo_MicroServ1.entity.Model.ValorantAPIResponseInfo;
import com.tharuntech.Demo_MicroServ1.entity.Model.ValorantBundleInfo;
import com.tharuntech.Demo_MicroServ1.entity.Model.ValorantSkinHub;
import com.tharuntech.Demo_MicroServ1.service.ValorantSkinHubGetAllInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest1 {

    @Autowired
    private ValorantSkinHubController controller1;

    @MockBean
    private ValorantSkinHubGetAllInfoService service;

    @Autowired
    private ObjectMapper objMap;


    @Test
    public void getAllBundleInfoTest() throws JsonProcessingException {

        List<ValoBundlePOJO> al1 = Arrays.asList(new ValoBundlePOJO("new", "new", "new", "new", 2, "new", 3, "new", 3, 4));

        when(service.getAllInfo()).thenReturn(al1);


        ResponseEntity<List<ValoBundlePOJO>> res1 = controller1.getAllBundleInfo();

        assertEquals(HttpStatus.OK, res1.getStatusCode());
        assertEquals(objMap.writeValueAsString(al1), objMap.writeValueAsString(res1.getBody()));
        verify(service, times(1)).getAllInfo();
    }


    @Test
    public void getAllSkinBundelsTest() throws JsonProcessingException {

        List<ValorantSkinHub> al1 = Arrays.asList(new ValorantSkinHub(1,"new","new","new","new",1,"new",2,"new"));


        when(service.getAllSkinBundels()).thenReturn(al1);


        ResponseEntity<List<ValorantSkinHub>> res1 = controller1.getAllSkinBundlesInfo();

        assertEquals(HttpStatus.OK, res1.getStatusCode());
        assertEquals(objMap.writeValueAsString(al1), objMap.writeValueAsString(res1.getBody()));
        verify(service, times(1)).getAllSkinBundels();
    }

    @Test
    public void getAllBundlePreParseInfoTest() throws JsonProcessingException{

        String status = "good";

        List<ValorantBundleInfo> al1 = Arrays.asList(new ValorantBundleInfo("new","new","new","new","new","new","new","new","new","new","new","new"));

        var obj1 = new ValorantAPIResponseInfo(al1,status);

        when(service.callExternalApi()).thenReturn(obj1);

        ResponseEntity<ValorantAPIResponseInfo> res2 = controller1.getAllBundlePreParseInfo();

        assertEquals(HttpStatus.OK, res2.getStatusCode());
        assertEquals(objMap.writeValueAsString(obj1),objMap.writeValueAsString(res2.getBody()));
        verify(service, times(1)).callExternalApi();
    }
}
