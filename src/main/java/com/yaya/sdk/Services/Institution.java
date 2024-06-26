package com.yaya.sdk.Services;

import com.yaya.sdk.ApiRequest.ApiClient;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Institution {

    private final ApiClient apiClient;
    private final ObjectMapper objectMapper;

    public Institution(ApiClient apiClient) {
        this.objectMapper = new ObjectMapper();
        this.apiClient = apiClient;
    }

    public com.yaya.sdk.Models.Institution[] listInstitution(String country) throws IOException, InterruptedException, ExecutionException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, Object> payload = new HashMap<>();
        payload.put("country", country);
        HttpResponse<String> response = apiClient.apiRequest("POST", "/financial-institution/list", "", payload);
        com.yaya.sdk.Models.Institution[] institutions = objectMapper.readValue(response.body(), com.yaya.sdk.Models.Institution[].class);
        return institutions;
    }
}