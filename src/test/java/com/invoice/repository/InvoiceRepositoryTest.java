package com.invoice.repository;

import com.invoice.entity.Invoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class InvoiceRepositoryTest {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Invoice invoice = Invoice.builder()
                .companyName("BigCompany")
                .emailAddress("test@test.com")
                .companyAddress("Stockholm")
                .build();

        entityManager.persist(invoice);
    }

    // Test shouldn't fail
    // todo: fix test
    @Test
    public void whenFindByInvoiceNumber_thenReturnInvoice() {
        Invoice invoice = invoiceRepository.findById(1L).get();
        assertEquals(invoice.getCompanyName(), "BigCompany");
    }

}