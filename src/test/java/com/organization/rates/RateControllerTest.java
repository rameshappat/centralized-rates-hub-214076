package com.organization.rates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Unit tests for RateController.
 */
@WebMvcTest(RateController.class)
public class RateControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private Rate rate;

    @BeforeEach
    public void setUp() {
        rate = new Rate();
        rate.setId(1L);
        rate.setType("deposit");
        rate.setValue(new BigDecimal("1.5"));
    }

    @Test
    public void testGetAllRates() throws Exception {
        mockMvc.perform(get("/api/rates"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCreateRate() throws Exception {
        mockMvc.perform(post("/api/rates")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"type\":\"deposit\", \"value\":1.5}")
            )
            .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}