package com.invoice.service;


import com.invoice.entity.Invoice;
import com.invoice.exceptions.InvoiceNotFoundException;
import com.invoice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> fetchInvoiceList() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice fetchInvoiceByInvoiceNumber(Long invoiceNumber) throws InvoiceNotFoundException {
        Optional<Invoice> invoice =
                invoiceRepository.findById(invoiceNumber);
        if(!invoice.isPresent()) {
            throw new InvoiceNotFoundException("Invoice Not Found");
        }
        return invoice.get();
    }

    @Override
    public void deleteInvoiceByInvoiceNumber(Long invoiceNumber) {
        invoiceRepository.deleteById(invoiceNumber);
    }

    // check equalsIgnoreCase
    //if not empty and not null
    @Override
    public Invoice updateInvoice(Long invoiceNumber, Invoice invoice) {
        Invoice depDB = invoiceRepository.findById(invoiceNumber).get();

        if(Objects.nonNull(invoice.getCompanyName()) && !"".equalsIgnoreCase(invoice.getCompanyName()))
        {
            depDB.setCompanyName(invoice.getCompanyName());
        }

        if(Objects.nonNull(invoice.getEmailAddress()) && !"".equalsIgnoreCase(invoice.getEmailAddress()))
        {
            depDB.setEmailAddress(invoice.getEmailAddress());
        }

        if(Objects.nonNull(invoice.getCompanyAddress()) && !"".equalsIgnoreCase(invoice.getCompanyAddress()))
        {
            depDB.setCompanyAddress(invoice.getCompanyAddress());
        }
        return invoiceRepository.save(depDB);
    }

    // the ignoreCase can be removed
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    @Override
    public Invoice fetchInvoiceByCompanyName(String companyName) {
        return invoiceRepository.findByCompanyNameIgnoreCase(companyName);
    }


}
