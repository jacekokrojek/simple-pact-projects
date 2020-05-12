package com.testarmy.demos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SimpleClient {

    String url;

    public SimpleClient(String url) {
        this.url = url;
    }

    public int getSimple(String id) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = url + "/client/simple";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        return response.getStatusCode() == HttpStatus.OK ? 0 : -1;
    }


}