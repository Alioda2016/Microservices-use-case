package com.demo.microservices.standardapiservice.controller;

import com.demo.microservices.standardapiservice.billInfo.InquiryProxy;
import com.demo.microservices.standardapiservice.billInfo.InquiryRequest;
import com.demo.microservices.standardapiservice.billInfo.InquiryResponse;
import com.demo.microservices.standardapiservice.billPayment.PaymentProxy;
import com.demo.microservices.standardapiservice.billPayment.PaymentRequest;
import com.demo.microservices.standardapiservice.billPayment.PaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController()
@RequestMapping("/standard-service")
public class StandardController {
    private final Logger logger = LoggerFactory.getLogger(StandardController.class);

    @Autowired
    private InquiryProxy inquiryProxy;

    @Autowired
    private PaymentProxy paymentProxy;

    @PostMapping("/billInfo")
    public InquiryResponse getBillInfo(@RequestBody InquiryRequest request) {
        return new RestTemplate().
                postForObject("http://localhost:8100/inquiry-service/inquiry", request,InquiryResponse.class);
    }


    @PostMapping("/billInfo-feign")
    public InquiryResponse getBillInfoFeign(@RequestBody InquiryRequest request) {
        logger.info("StandardController inquiry request: {}", request);
        InquiryResponse inquiryResponse = inquiryProxy.executeInquiryRequest(request);
        InquiryResponse inquiryResponse1 = new InquiryResponse(inquiryResponse.getBillId(),
                inquiryResponse.getClientName(), inquiryResponse.getDueAmount(),
                inquiryResponse.getDueDate(), inquiryResponse.getBillNumber(), inquiryResponse.getEnvironment());
        logger.info("StandardController inquiry response: {}", inquiryResponse1);
        return inquiryResponse1;
    }


    @PostMapping("/payment")
    public PaymentResponse sendPaymentRequest(@RequestBody PaymentRequest request) {
        return new RestTemplate().
                postForObject("http://localhost:8200/payment-service/payment", request,PaymentResponse.class);
    }

    @PostMapping("/payment-feign")
    public PaymentResponse sendPaymentRequestFeign(@RequestBody PaymentRequest request) {
        logger.info("StandardController payment request: {}", request);
        PaymentResponse paymentResponse = paymentProxy.executePaymentRequest(request);
        PaymentResponse paymentResponse1 = new PaymentResponse(paymentResponse.getStatus(),
                paymentResponse.getMessage(), paymentResponse.getReferenceNumber(), paymentResponse.getEnvironment());
        logger.info("StandardController payment response: {}", request);
        return paymentResponse1;
    }
}
