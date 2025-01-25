package com.tharuntech.Demo_MicroServ1;

import com.tharuntech.Demo_MicroServ1.entity.Model.BundleRateing;
import com.tharuntech.Demo_MicroServ1.entity.Model.ValoBundlePOJO;
import com.tharuntech.Demo_MicroServ1.entity.Model.ValorantAPIResponseInfo;
import com.tharuntech.Demo_MicroServ1.entity.Model.ValorantSkinHub;
import com.tharuntech.Demo_MicroServ1.repository.RateingRepo;
import com.tharuntech.Demo_MicroServ1.repository.ValoSkinHubRepo;
import com.tharuntech.Demo_MicroServ1.service.Impl.ValorantSkinHubGetAllInfoServiceImpl;
import com.tharuntech.Demo_MicroServ1.service.ValorantSkinHubGetAllInfoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoMicroServ1ApplicationTests {

	@Autowired
	private ValorantSkinHubGetAllInfoService service;

	@InjectMocks
	private ValorantSkinHubGetAllInfoServiceImpl service2;

	@MockBean
	private ValoSkinHubRepo repo;

	@Mock
	private RestTemplate restTemplate;

	@MockBean
	private RateingRepo rateingRepo;

	@Spy
	private ValorantSkinHubGetAllInfoServiceImpl serviceImp;

	@Test
	public void getAllSkinBundelsTest(){
		when(repo.findAll()).thenReturn(Arrays.asList(new ValorantSkinHub(1, "uuid1", "Prime 2.0", "iconVert1", "iconHori1", 5, "Battlepass", 1000, "VP"),
				new ValorantSkinHub(2, "uuid2", "Glitchpop 2.0", "iconVert2", "iconHori2", 4, "Store", 1700, "VP"),
				new ValorantSkinHub(3, "uuid3", "Ion", "iconVert3", "iconHori3", 3, "Event Pass", 2000, "VP")
		));

		assertEquals(3,service.getAllSkinBundels().size());
	}

	@Test
	public void addAllBundlesTodbTest1(){
		when(repo.findById(1)).thenReturn( Optional.of(new ValorantSkinHub(2,"string","string","string","string",3,"string",33,"string")));
		assertEquals("Force Updated our database with Latest Update",service.addAllBundlesTodb("true"));
	}

	@Test
	public void addAllBundlesTodbTest2(){
		when(repo.findById(1)).thenReturn( Optional.of(new ValorantSkinHub(2,"string","string","string","string",3,"string",33,"string")));
		assertEquals("data already exist in Db",service.addAllBundlesTodb("false"));
	}
	@Test
	public void addAllBundlesTodbTest3(){
		when(repo.findById(1)).thenReturn(Optional.empty());
		assertEquals("data Successfully added to our DB",service.addAllBundlesTodb("false"));
	}

	@Test
	public void getAllInfoTest(){
//		BundleRateing al1 = new BundleRateing("something1",3,33);
		BundleRateing al1 = new BundleRateing();
		when(rateingRepo.findByUuid("something")).thenReturn(Optional.of(al1));

//		List<ValorantSkinHub> ValopojoObj = Arrays.asList(new ValorantSkinHub(1, "uuid1", "Prime 2.0", "iconVert1", "iconHori1", 5, "Battlepass", 1000, "VP"));
		List<ValorantSkinHub> ValopojoObj = Arrays.asList(new ValorantSkinHub());
		when(repo.findAll()).thenReturn(ValopojoObj);

		List<ValoBundlePOJO> pojoObj = Arrays.asList(new ValoBundlePOJO());
		assertEquals(pojoObj,service.getAllInfo());
	}

	@Test
	public void callExternalApiTest(){
//		String expectedResponseBody = "{\"data\": \"success\"}";
//		String mockedServiceUrl = "http://mocked-api.com";
		//used to directly manipulate the serviceUrl with our mockedUrl
//		ReflectionTestUtils.setField(service, "serviceUrl", mockedServiceUrl);
		//mocks the restTemplate request
//		when(restTemplate.getForEntity(anyString(), eq(String.class))).thenReturn(
//				new ResponseEntity<>(expectedResponseBody, HttpStatus.OK));
		ValorantAPIResponseInfo accVal = service.callExternalApi();
		assertEquals(true,accVal.getData().size()>1);

	}
}
