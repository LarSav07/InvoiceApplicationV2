package com.invoice.repository;

import com.invoice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository <Invoice, Long> {

    Invoice findByCompanyNameIgnoreCase(String companyName);

}
