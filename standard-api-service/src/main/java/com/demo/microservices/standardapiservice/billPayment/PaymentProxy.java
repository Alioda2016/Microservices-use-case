package com.demo.microservices.standardapiservice.billPayment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "bill-payment", url = "http://localhost:8200/payment-service")
@FeignClient(name = "bill-payment")
public interface PaymentProxy {

    @PostMapping("/payment-service/payment")
    public PaymentResponse executePaymentRequest(@RequestBody PaymentRequest request);
}
