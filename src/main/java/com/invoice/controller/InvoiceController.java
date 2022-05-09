package com.invoice.controller;

import com.invoice.entity.Invoice;
import com.invoice.Exceptions.InvoiceNotFoundException;
import com.invoice.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
//@Request-body converts json to invoice object


@RestController
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    // Logging -- records each acton we take
    private final Logger LOGGER =
            LoggerFactory.getLogger(InvoiceController.class);

    @PostMapping("/invoices")
    public Invoice saveInvoice(@Valid @RequestBody Invoice invoice) {
        LOGGER.info("Inside saveInvoice of InvoiceController");
        return invoiceService.saveInvoice(invoice);
    }

    @GetMapping("/invoices")
    public List<Invoice> fetchInvoiceList() {
        LOGGER.info("Inside fetchInvoiceList of InvoiceController");
        return invoiceService.fetchInvoiceList();
    }

    // add path variable to get single id
    @GetMapping("/invoices/{invoiceNumber}")
    public Invoice fetchInvoiceByInvoiceNumber(@PathVariable("invoiceNumber") Long invoiceNumber) throws InvoiceNotFoundException {
        return invoiceService.fetchInvoiceByInvoiceNumber(invoiceNumber);
    }

    @DeleteMapping("/invoices/{invoiceNumber}")
    public String deleteInvoiceByInvoiceNumber(@PathVariable("invoiceNumber") Long invoiceNumber) {
        invoiceService.deleteInvoiceByInvoiceNumber(invoiceNumber);
        return "Invoice deleted Successfully";
    }

    @PutMapping("/invoices/{invoiceNumber}")
    public Invoice updateInvoice(@PathVariable("invoiceNumber") Long invoiceNumber,
                                    @RequestBody Invoice invoice) {
        return invoiceService.updateInvoice(invoiceNumber, invoice);
    }

    @GetMapping("/invoices/name/{companyName}")
    public Invoice fetchInvoiceByCompanyName(@PathVariable("companyName") String companyName) {
        return invoiceService.fetchInvoiceByCompanyName(companyName);
    }

    // todo: complete other endpoints

}
