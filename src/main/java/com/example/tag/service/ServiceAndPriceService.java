package com.example.tag.service;

import com.example.tag.dto.request.*;
import com.example.tag.model.ServiceAndPrice;

import java.util.List;

public interface ServiceAndPriceService {

    void addServiceAndPrice(ServiceAndPriceAddRequestModel serviceAndPriceAddRequestModel);

    void updateServiceAndPrice(ServiceAndPriceUpdateRequestModel serviceAndPriceUpdateRequestModel);

    void deleteServiceAndPrice(ServiceAndPriceDeleteRequestModel serviceAndPriceDeleteRequestModel);

    List<ServiceAndPrice> getServiceAndPrices(String username);


}
