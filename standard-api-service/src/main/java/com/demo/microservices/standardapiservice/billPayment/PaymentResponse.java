package com.demo.microservices.standardapiservice.billPayment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentResponse {
    private String status;
    private String message;
    private String referenceNumber;
    private String environment;
}
