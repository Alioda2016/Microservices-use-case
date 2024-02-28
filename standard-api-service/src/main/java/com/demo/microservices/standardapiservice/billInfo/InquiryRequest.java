package com.demo.microservices.standardapiservice.billInfo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InquiryRequest {
    private String serviceCode;
    private String partner;
    private String billNumber;
}
