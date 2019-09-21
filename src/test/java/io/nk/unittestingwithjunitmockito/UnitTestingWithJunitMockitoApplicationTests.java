package io.nk.unittestingwithjunitmockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//if we want to override a specific configuration for the test we can create test-configuration.properties file in the test folder and use it like this
//so what ever we write in here will override the main application.propertie file
//@TestPropertySource(locations = {"classpath:test-configuration.properties"})
public class UnitTestingWithJunitMockitoApplicationTests {

    @Test
    public void contextLoads() {


    }
}
