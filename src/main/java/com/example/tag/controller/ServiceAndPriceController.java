package com.example.tag.controller;

import com.example.tag.dto.request.*;
import com.example.tag.dto.response.BaseResponseModel;
import com.example.tag.model.ServiceAndPrice;
import com.example.tag.service.ServiceAndPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/service-and-price")
public class ServiceAndPriceController {
    private final ServiceAndPriceService serviceAndPriceService;

    @PostMapping(value = "/add")
    public ResponseEntity<BaseResponseModel> add(@RequestBody ServiceAndPriceAddRequestModel serviceAndPriceAddRequestModel) {
        serviceAndPriceService.addServiceAndPrice(serviceAndPriceAddRequestModel);
        return ResponseEntity.ok(BaseResponseModel.builder().success(true).build());
    }

    @PostMapping(value = "/update")
    public ResponseEntity<BaseResponseModel> update(@RequestBody ServiceAndPriceUpdateRequestModel serviceAndPriceUpdateRequestModel) {
        serviceAndPriceService.updateServiceAndPrice(serviceAndPriceUpdateRequestModel);
        return ResponseEntity.ok(BaseResponseModel.builder().success(true).build());
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<BaseResponseModel> delete(@RequestBody ServiceAndPriceDeleteRequestModel serviceAndPriceDeleteRequestModel) {
        serviceAndPriceService.deleteServiceAndPrice(serviceAndPriceDeleteRequestModel);
        return ResponseEntity.ok(BaseResponseModel.builder().success(true).build());
    }

    @PostMapping(value = "")
    public ResponseEntity<List<ServiceAndPrice>> getServiceAndPrices(@RequestBody ServiceAndPriceListRequestModel serviceAndPriceListRequestModel) {
        List<ServiceAndPrice> serviceAndPriceList = serviceAndPriceService.getServiceAndPrices(serviceAndPriceListRequestModel.getUsername());
        return ResponseEntity.ok(serviceAndPriceList);
    }
}
