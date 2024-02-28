package com.demo.microservices.billinfoservice.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BillInfoRequest {
    private String serviceCode;
    private String partner;
    private String billNumber;
    private String environment;
}
