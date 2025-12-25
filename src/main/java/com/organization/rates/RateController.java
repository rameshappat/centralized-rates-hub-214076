package com.organization.rates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RateController handles requests related to financial rates.
 */
@RestController
@RequestMapping("/api/rates")
public class RateController {
    private final RateService rateService;

    @Autowired
    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @GetMapping
    public ResponseEntity<List<Rate>> getAllRates() {
        return new ResponseEntity<>(rateService.getAllRates(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rate> createRate(@RequestBody Rate rate) {
        return new ResponseEntity<>(rateService.createRate(rate), HttpStatus.CREATED);
    }
}