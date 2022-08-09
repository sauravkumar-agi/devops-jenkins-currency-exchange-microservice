package com.in28minutes.springboot.microservice.example.currencyconversion;


import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CurrencyConversionController.class)
public class MockTest {
	@Autowired
	private MockMvc mockMvc;

	
	@MockBean
	private CurrencyConversionController service;
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/currency-converter-feign/from/EUR/to/INR/quantity/100")).andDo(print()).andExpect(status().isOk());
				//.andExpect(content().string(containsString("7500")));
	}
	BigDecimal conversionMultiple = new BigDecimal(75);
	BigDecimal quantity = new BigDecimal(100);
	BigDecimal totalCalculatedAmount = new BigDecimal(7500);
	CurrencyConversionBean RECORD_1 = new CurrencyConversionBean(1L,"EUR","INR",conversionMultiple,quantity,totalCalculatedAmount, 8100);

	@Test
	public void shouldReturnMessageFromFeignService() throws Exception {
		
		when(service.convertCurrencyFeign("EUR", "INR", quantity)).thenReturn(RECORD_1);
		this.mockMvc.perform(get("/currency-converter-feign/from/EUR/to/INR/quantity/100")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("7500")));
	}
	
	@Test
	public void shouldReturnMessageFromService() throws Exception {
		
		when(service.convertCurrency("EUR", "INR", quantity)).thenReturn(RECORD_1);
		this.mockMvc.perform(get("/currency-converter/from/EUR/to/INR/quantity/100")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("7500")));
	}
	
	
}
