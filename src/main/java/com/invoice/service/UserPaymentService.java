package com.invoice.service;

import com.invoice.entity.Payment;
import com.invoice.entity.PaymentStatus;
import com.invoice.entity.Product;
import com.invoice.exceptions.InvoiceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserPaymentService {
    Payment savePayment(Payment payment);

    Product saveProduct(Product product);

    PaymentStatus savePaymentStatus(PaymentStatus paymentStatus);

    List<Payment> fetchPaymentList();

    List<Product> fetchProductList();

    List<PaymentStatus> fetchPaymentStatusList();

    Payment fetchPaymentByPaymentId(Long paymentId) throws InvoiceNotFoundException;

    Product fetchProductByProductId(Long productId) throws InvoiceNotFoundException;

    PaymentStatus fetchPaymentStatusById(Long statusId) throws InvoiceNotFoundException;

    void deletePaymentByPaymentId(Long paymentId);
    void deleteProductByProductId(Long productId);

    void deletePaymentStatusById(Long paymentStatusId);
}
