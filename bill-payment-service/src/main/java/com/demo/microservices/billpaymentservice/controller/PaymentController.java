package com.demo.microservices.billpaymentservice.controller;

import com.demo.microservices.billpaymentservice.request.PaymentRequest;
import com.demo.microservices.billpaymentservice.response.PaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-service")
public class PaymentController {
    private final Logger logger = LoggerFactory.getLogger(PaymentController.class);
    @Autowired
    private Environment environment;
    @PostMapping("/payment")
    public PaymentResponse executePaymentRequest(@RequestBody PaymentRequest request) {
        logger.info("PaymentController request: {}", request);

        PaymentResponse paymentResponse = new PaymentResponse("Success", "Payment Successfully",
                "3456785643", environment.getProperty("local.server.port"));
        logger.info("PaymentController response: {}", paymentResponse);
        return paymentResponse;
    }
}
