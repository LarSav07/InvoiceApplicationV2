package com.invoice.controller;

import com.invoice.entity.Invoice;
import com.invoice.exceptions.InvoiceNotFoundException;
import com.invoice.service.InvoiceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


// testing controller tests the end points
@WebMvcTest(InvoiceController.class)
class InvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InvoiceService invoiceService;

    private Invoice invoice;

    //output
    @BeforeEach
    void setUp() {
        invoice = Invoice.builder()
                .companyName("BigCompany")
                .emailAddress("test@test.com")
                .companyAddress("Stockholm")
                .invoiceNumber(1L)
                .build();
    }

    //input
    @Test
    void saveInvoice() throws Exception {
      Invoice  invoiceInvoice = Invoice.builder()
                .companyName("BigCompany")
                .emailAddress("test@test.com")
                .companyAddress("Stockholm")
                .build();

        Mockito.when(invoiceService.saveInvoice(invoiceInvoice))
                .thenReturn(invoice);

        mockMvc.perform(post("/invoices")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"companyName\":\"BigCompany\",\n" +
                        "    \"companyAddress\":\"test@test.com\",\n" +
                        "    \"emailAddress\":\"Stockholm\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchInvoiceByInvoiceNumber() throws Exception {
        Mockito.when(invoiceService.fetchInvoiceByInvoiceNumber(1L))
                .thenReturn(invoice);

        mockMvc.perform(get("/invoices/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.companyName").
                        value(invoice.getCompanyName()));
    }
}