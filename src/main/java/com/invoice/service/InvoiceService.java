package com.invoice.service;

import com.invoice.entity.Invoice;
import com.invoice.Exceptions.InvoiceNotFoundException;

import java.util.List;

public interface InvoiceService {
    public Invoice saveInvoice(Invoice invoice);

    public List<Invoice> fetchInvoiceList();

    public Invoice fetchInvoiceByInvoiceNumber(Long invoiceNumber) throws InvoiceNotFoundException;

    public void deleteInvoiceByInvoiceNumber(Long invoiceNumber);


    Invoice updateInvoice(Long invoiceNumber, Invoice invoice);

    Invoice fetchInvoiceByCompanyName(String invoice);
}
