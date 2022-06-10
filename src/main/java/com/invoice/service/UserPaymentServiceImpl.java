package com.invoice.service;

import com.invoice.entity.Payment;
import com.invoice.entity.PaymentStatus;
import com.invoice.entity.Product;
import com.invoice.exceptions.InvoiceNotFoundException;
import com.invoice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPaymentServiceImpl implements  UserPaymentService {

    @Autowired
    private PaymentRepository  paymentRepository;
    @Autowired
    private PaymentStatusRepository paymentStatusRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public PaymentStatus savePaymentStatus(PaymentStatus paymentStatus) {
        return paymentStatusRepository.save(paymentStatus);
    }

    @Override
    public List<Payment> fetchPaymentList() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Product> fetchProductList() {
        return productRepository.findAll();
    }
    @Override
    public List<PaymentStatus> fetchPaymentStatusList() {
        return paymentStatusRepository.findAll();
    }

    @Override
    public Payment fetchPaymentByPaymentId(Long paymentId) throws InvoiceNotFoundException  {
        Optional<Payment> payment =
                paymentRepository.findById(paymentId);
        if (!payment.isPresent()) {
            throw new InvoiceNotFoundException("Payment not found for id: " + paymentId);
        }
        return payment.get();
    }

    @Override
    public Product fetchProductByProductId(Long productId) throws InvoiceNotFoundException {
        Optional<Product> product =
                productRepository.findById(productId);
        if (!product.isPresent()) {
            throw new InvoiceNotFoundException("Product not found for id: " + productId);
        }
        return product.get();
    }
    @Override
    public PaymentStatus fetchPaymentStatusById(Long statusId) throws InvoiceNotFoundException {
        Optional<PaymentStatus> paymentStatus =
                paymentStatusRepository.findById(statusId);
        if (!paymentStatus.isPresent()) {
            throw new InvoiceNotFoundException("PaymentStatus not found for id: " + statusId);
        }
        return paymentStatus.get();
    }
    @Override
    public void deletePaymentByPaymentId(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    @Override
    public void deleteProductByProductId(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public void deletePaymentStatusById(Long paymentStatusId) {
        paymentStatusRepository.deleteById(paymentStatusId);
    }
}
