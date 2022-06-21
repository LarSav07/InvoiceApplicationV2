package com.invoice.service;

import com.invoice.entity.Invoice;
import com.invoice.exceptions.InvoiceNotFoundException;

import java.util.List;

public interface InvoiceService {
    Invoice saveInvoice(Invoice invoice);

    List<Invoice> fetchInvoiceList();

    Invoice fetchInvoiceByInvoiceNumber(Long invoiceNumber) throws InvoiceNotFoundException;

    void deleteInvoiceByInvoiceNumber(Long invoiceNumber);

    Invoice updateInvoice(Long invoiceNumber, Invoice invoice);

    Invoice fetchInvoiceByCompanyName(String invoice);
}
