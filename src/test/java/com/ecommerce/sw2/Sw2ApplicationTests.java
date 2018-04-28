package com.ecommerce.sw2;

import com.ecommerce.sw2.Models.Services.BrandServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@WebAppConfiguration
public class Sw2ApplicationTests {

	@Test
	public void contextLoads(){
	}

}
