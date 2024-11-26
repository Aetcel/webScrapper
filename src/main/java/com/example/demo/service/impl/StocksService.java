package com.example.demo.service.impl;

import com.example.demo.service.StocksServiceInterface;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class StocksService implements StocksServiceInterface {

    public void InterdayReq () throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://alpha-vantage.p.rapidapi.com/query?datatype=json&output_size=compact&interval=5min&function=TIME_SERIES_INTRADAY&symbol=MSFT"))
		.header("x-rapidapi-key", "Sign Up for Key")
		.header("x-rapidapi-host", "alpha-vantage.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
