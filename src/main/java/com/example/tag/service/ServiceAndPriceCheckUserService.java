package com.example.tag.service;

import com.example.tag.dto.request.ServiceAndPriceAddRequestModel;
import com.example.tag.dto.request.ServiceAndPriceDeleteRequestModel;
import com.example.tag.dto.request.ServiceAndPriceUpdateRequestModel;
import com.example.tag.model.ServiceAndPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class ServiceAndPriceCheckUserService implements ServiceAndPriceService {
    private final UserService userService;
    private final ServiceAndPriceService serviceAndPriceService;

    @Transactional
    @Override
    public void addServiceAndPrice(ServiceAndPriceAddRequestModel serviceAndPriceAddRequestModel){
        userService.checkUser(serviceAndPriceAddRequestModel.getUsername());
        serviceAndPriceService.addServiceAndPrice(serviceAndPriceAddRequestModel);
    }

    @Transactional
    @Override
    public void updateServiceAndPrice(ServiceAndPriceUpdateRequestModel serviceAndPriceUpdateRequestModel) {
        userService.checkUser(serviceAndPriceUpdateRequestModel.getUsername());
        serviceAndPriceService.updateServiceAndPrice(serviceAndPriceUpdateRequestModel);
    }

    @Transactional
    @Override
    public void deleteServiceAndPrice(ServiceAndPriceDeleteRequestModel serviceAndPriceDeleteRequestModel) {
        userService.checkUser(serviceAndPriceDeleteRequestModel.getUsername());
        serviceAndPriceService.deleteServiceAndPrice(serviceAndPriceDeleteRequestModel);
    }

    @Override
    public List<ServiceAndPrice> getServiceAndPrices(String username){
        userService.checkUser(username);
        return serviceAndPriceService.getServiceAndPrices(username);
    }
}