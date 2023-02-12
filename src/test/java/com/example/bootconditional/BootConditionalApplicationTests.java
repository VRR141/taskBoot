package com.example.bootconditional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class BootConditionalApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Container
    private final GenericContainer<?> devApp = new GenericContainer<>("devapp:latest")
            .withExposedPorts(8082);

    @Container
    private final GenericContainer<?> prodApp = new GenericContainer<>("prodapp:latest")
            .withExposedPorts(8081);

    private final String EXPECTED_FROM_PROD = "Current profile is production";

    private final String EXPECTED_FROM_DEV = "Current profile is dev";

    @Test
    void Dev_Should_Return_Correct_Message() {
        int devappPort = devApp.getMappedPort(8082);

        ResponseEntity<String> fromDevApp =
                restTemplate.getForEntity(
                        String.format("http://localhost:%s/profile", devappPort), String.class);


        Assertions.assertEquals(EXPECTED_FROM_DEV, fromDevApp.getBody());
    }

    @Test
    void Prod_Should_Return_Correct_Message(){
        int prodappPort = prodApp.getMappedPort(8081);

        ResponseEntity<String> fromProdApp =
                restTemplate.getForEntity(
                        String.format("http://localhost:%s/profile", prodappPort), String.class);

        Assertions.assertEquals(EXPECTED_FROM_PROD, fromProdApp.getBody());
    }

}
