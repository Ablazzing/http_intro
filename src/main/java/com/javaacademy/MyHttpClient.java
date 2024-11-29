package com.javaacademy;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

public class MyHttpClient {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://api.coindesk.com/v1/bpi/currentprice.json").get().build();
        Response response = client.newCall(request).execute();
        System.out.println("code: " + response.code());
        //System.out.println("body:" + response.body().string());

        ObjectMapper mapper = new ObjectMapper();
//        TypeReference<Map<String, Object>> typeReference = new TypeReference<>() {
//        };
//        String json = response.body().string();
//        Map<String, Object> map = mapper.readValue(json, typeReference);
//        System.out.println(map);
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        String json = response.body().string();
        System.out.println(json);
        BitcoinData bitcoinData = mapper.readValue(json, BitcoinData.class);
        System.out.println(bitcoinData);



    }
}
