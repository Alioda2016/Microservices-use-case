package com.demo.microservices.billinfoservice.controller;

import com.demo.microservices.billinfoservice.request.BillInfoRequest;
import com.demo.microservices.billinfoservice.response.BillInfoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/inquiry-service")
public class BillInfoController {
    private final Logger logger = LoggerFactory.getLogger(BillInfoController.class);
    @Autowired
    private Environment environment;
    @PostMapping("inquiry")
    public BillInfoResponse executeInquiryRequest(@RequestBody BillInfoRequest request) {
        logger.info("BillInfoController request: {}", request);
        return new BillInfoResponse("1000", "Ali Ouda", BigDecimal.TEN,
                LocalDate.now(), request.getBillNumber(), environment.getProperty("local.server.port"));
    }
}
