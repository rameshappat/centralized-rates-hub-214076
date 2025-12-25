package com.organization.rates;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * RateService contains the business logic for managing rates.
 */
@Service
public class RateService {
    private final List<Rate> rates = new ArrayList<>(); // Temporary storage

    public List<Rate> getAllRates() {
        return rates;
    }

    public Rate createRate(Rate rate) {
        rates.add(rate);
        return rate;
    }
}