package com.example.demo.controller;

import com.example.demo.service.impl.StocksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/stocks")
public class StocksServiceController {
    private final StocksService stocksService;

    public StocksServiceController(StocksService stocksService) {
        this.stocksService = stocksService;
    }

    @GetMapping("/one")
    public ResponseEntity<String> getStocks(){
        try {stocksService.InterdayReq();
            return ResponseEntity.ok().body("OK");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
