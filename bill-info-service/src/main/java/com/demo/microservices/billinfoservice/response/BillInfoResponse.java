package com.demo.microservices.billinfoservice.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BillInfoResponse {
    private String billId;
    private String clientName;
    private BigDecimal dueAmount;
    private LocalDate dueDate;
    private String billNumber;
    private String environment;
}
