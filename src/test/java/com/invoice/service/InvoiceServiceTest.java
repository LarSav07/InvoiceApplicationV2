package com.invoice.service;

import com.invoice.entity.Invoice;
import com.invoice.repository.InvoiceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceServiceTest {

    @MockBean
    private InvoiceRepository invoiceRepository;
    @Autowired
    private InvoiceService invoiceService;

    //builder
    @BeforeEach
    void setUp() {
        Invoice invoice =
                Invoice.builder()
                        .companyAddress("Stockholm")
                        .invoiceNumber(1L)
                        .emailAddress("Test@test.com")
                        .companyName("BigCompany")
                        .build();

        Mockito.when(invoiceRepository.findByCompanyNameIgnoreCase("BigCompany"))
                .thenReturn(invoice);
    }

    @Test
    public void whenValidCompanyName_thenInvoiceShouldBeFound() {
        String companyName = "BigCompany";
        Invoice found =
                invoiceService.fetchInvoiceByCompanyName(companyName);
        assertEquals(companyName, found.getCompanyName());
    }

    //todo: finish writing tests

}