package com.example.springbootvertexendpoint.config;


import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GoogleCredentialsHelper {
    public String getAccessToken() throws IOException {
        return GoogleCredentials.getApplicationDefault()
//                .fromStream(new FileInputStream("/PATH/TO/SERVICE_ACCOUNT.json"))
                .createScoped("https://www.googleapis.com/auth/cloud-platform")
                .refreshAccessToken()
                .getTokenValue();
    }
}
