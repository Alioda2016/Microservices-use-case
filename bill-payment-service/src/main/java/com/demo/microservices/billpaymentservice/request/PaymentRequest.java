package com.demo.microservices.billpaymentservice.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PaymentRequest {
    private String partner;
    private String serviceCode;
    private String billId;
    private BigDecimal dueAmount;
    private BigDecimal fees;
}
