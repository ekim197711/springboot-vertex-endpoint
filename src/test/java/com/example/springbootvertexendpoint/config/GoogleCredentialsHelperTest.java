package com.example.springbootvertexendpoint.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class GoogleCredentialsHelperTest {
    @Autowired
    GoogleCredentialsHelper helper;

    @Test
    public void getAccessToken() throws IOException {
        String accessToken = helper.getAccessToken();
        Assertions.assertThat(accessToken).isNotBlank();
        Assertions.assertThat(accessToken).hasSizeGreaterThan(20);
        Assertions.assertThat(accessToken).contains(".");
        Assertions.assertThat(accessToken.split("\\.")).hasSize(2);
//        System.out.println(accessToken);
    }
}