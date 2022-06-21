package com.invoice.controller;

import com.invoice.service.InvoicePDFExporter;
import com.invoice.entity.Invoice;
import com.invoice.exceptions.InvoiceNotFoundException;
import com.invoice.service.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Operation(summary = "This is to fetch All the Invoices")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Fetched All the Invoices",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content)
    })
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

    // Export to PDF
//    @GetMapping("/invoices/export")
//    public void exportToPDF(HttpServletResponse response) throws IOException {
//        response.setContentType("/application/pdf");
//
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
//        String currentDateTime = dateFormat.format(new Date());
//
//        String headerKey = "Content-Disposition";
//        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
//
//        response.setHeader(headerKey, headerValue);
//
//        List<Invoice> listInvoices = invoiceService.fetchInvoiceList();
//
//        InvoicePDFExporter exporter = new InvoicePDFExporter(listInvoices);
//        exporter.export(response);
//    }

}
