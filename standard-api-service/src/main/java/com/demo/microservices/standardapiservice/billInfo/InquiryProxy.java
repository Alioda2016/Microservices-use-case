package com.demo.microservices.standardapiservice.billInfo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(value = "bill-info", url = "http://localhost:8100/inquiry-service")
@FeignClient(value = "bill-info")
public interface InquiryProxy {
    @PostMapping("/inquiry-service/inquiry")
    public InquiryResponse executeInquiryRequest(@RequestBody InquiryRequest request);
}
