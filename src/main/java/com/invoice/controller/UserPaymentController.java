package com.invoice.controller;
import com.invoice.entity.Invoice;
import com.invoice.entity.Payment;
import com.invoice.entity.PaymentStatus;
import com.invoice.entity.Product;
import com.invoice.exceptions.InvoiceNotFoundException;
import com.invoice.service.UserPaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserPaymentController {

    @Autowired
    private UserPaymentService userPaymentService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(InvoiceController.class);

    @PostMapping("/payment")
    public Payment savePayment(@Valid @RequestBody Payment payment) {
        LOGGER.info("Inside savePayment of userPaymentService");
        return userPaymentService.savePayment(payment);
    }

    @PostMapping("/product")
    public Product saveProduct(@Valid @RequestBody Product product) {
        LOGGER.info("Inside saveProduct of userPaymentService");
        return userPaymentService.saveProduct(product);
    }

    @PostMapping("/paymentStatus")
    public PaymentStatus savePaymentStatus(@Valid @RequestBody PaymentStatus paymentStatus) {
        LOGGER.info("Inside savePaymentStatus of userPaymentService");
        return userPaymentService.savePaymentStatus(paymentStatus);
    }

    @GetMapping("/payment")
    public List<Payment> fetchPaymentList() {
        LOGGER.info("Inside fetchPaymentList of userPaymentService");
        return userPaymentService.fetchPaymentList();
    }

    @GetMapping("/product")
    public List<Product> fetchProductList() {
        LOGGER.info("Inside fetchProductList of userPaymentService");
        return userPaymentService.fetchProductList();
    }

    // probably wont need this
    @GetMapping("/paymentStatus")
    public List<PaymentStatus> fetchPaymentStatusList() {
        LOGGER.info("Inside fetchPaymentStatusList of userPaymentService");
        return userPaymentService.fetchPaymentStatusList();
    }

    @GetMapping("/payment/{paymentId}")
    public Payment fetchPaymentByPaymentId(@PathVariable(value = "paymentId") Long paymentId) throws InvoiceNotFoundException{
        LOGGER.info("Inside getPaymentById of userPaymentService");
        return userPaymentService.fetchPaymentByPaymentId(paymentId);
    }

    @GetMapping("/product/{productId}")
    public Product fetchProductByProductId(@PathVariable(value = "productId") Long productId) throws InvoiceNotFoundException {
        LOGGER.info("Inside fetchProductByProductId of userPaymentService");
        return userPaymentService.fetchProductByProductId(productId);
    }

    @GetMapping("/paymentStatus/{id}")
    public PaymentStatus fetchPaymentStatusById(@PathVariable(value = "id") Long statusId) throws InvoiceNotFoundException {
        LOGGER.info("Inside fetchProductByProductId of userPaymentService");
        return userPaymentService.fetchPaymentStatusById(statusId);
    }

    @DeleteMapping("/payment/{paymentId}")
    public String deletePaymentByPaymentId(@PathVariable(value = "paymentId") Long paymentId) {
        userPaymentService.deletePaymentByPaymentId(paymentId);
        return "Payment deleted Successfully";
    }

    @DeleteMapping("/product/{productId}")
    public String deleteProductByProductId(@PathVariable(value = "productId") Long productId) {
        userPaymentService.deleteProductByProductId(productId);
        return "Product deleted Successfully";
    }

    @DeleteMapping("/paymentStatus/{id}")
    public String deletePaymentStatusById(@PathVariable(value = "id") Long paymentStatusId) {
        userPaymentService.deletePaymentStatusById(paymentStatusId);
        return "Product deleted Successfully";
    }

}
