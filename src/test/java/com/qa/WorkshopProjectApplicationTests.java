package com.qa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test") // sets the profile to test for this test. 
class WorkshopProjectApplicationTests {

	@Test
	void contextLoads() {
	}

}
