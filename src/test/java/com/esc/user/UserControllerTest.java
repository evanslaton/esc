package com.esc.user;

import escintegration.EscIntegrationSuite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testServeHomePage() {
        EscIntegrationSuite testSuite = new EscIntegrationSuite(port, restTemplate);
        testSuite.createEntity();
        testSuite.request("GET", "/");
        assertEquals(200, testSuite.responseCodeInt());
        assertTrue(testSuite.responseBody().contains("<h1>SPLASH PAGE</h1>"));
    }

    @Test
    public void testServeSignUpPage() {
        EscIntegrationSuite testSuite = new EscIntegrationSuite(port, restTemplate);
        testSuite.createEntity();
        testSuite.request("GET", "/signup");
        assertEquals(200, testSuite.responseCodeInt());
        assertTrue(testSuite.responseBody().contains("<h1>SIGNUP PAGE</h1>"));
    }

    @Test
    public void testCreateNewUser() {
        EscIntegrationSuite testSuite = new EscIntegrationSuite(port, restTemplate);
        testSuite.setBody("username", "testuser");
        testSuite.setBody("password", "testpass");
        testSuite.setBody("phoneNumber", "555-555-5555");
        testSuite.createEntity();
        testSuite.request("POST", "/signup");
        assertEquals(302, testSuite.responseCodeInt());
        assertTrue(testSuite.responseCookieIndex(0).contains("JSESSIONID"));
    }

//    @Test
//    public void testServeProfilePage() {
//
//
//    }
}