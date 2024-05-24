package com.example.springbootvertexendpoint.classifier;

import com.example.springbootvertexendpoint.config.GoogleCredentialsHelper;
import lombok.RequiredArgsConstructor;
import org.apache.http.entity.ContentType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

@Service
@RequiredArgsConstructor
public class ClassifierService {
    private static final String ENDPOINT_ID = "1172719310976581632";
    private static String PROJECT_ID = "540600113697";
    private static final String URL = String.format(
            "https://us-central1-aiplatform.googleapis.com/v1/projects/%s/locations/us-central1/endpoints/%s:predict",
            PROJECT_ID, ENDPOINT_ID);
    private final GoogleCredentialsHelper credentialsHelper;

    public String classifyThis(String jsonFile) throws IOException {
        String accessToken = credentialsHelper.getAccessToken();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
        RequestEntity<String> request = RequestEntity.post(URI.create(URL))
                .headers(httpHeaders)
                .body(jsonFile, String.class);

        ResponseEntity<String> response = new RestTemplate().exchange(request, String.class);
        return response.getBody();
    }


}