package com.example.tag.service;

import com.example.tag.dto.request.*;
import com.example.tag.exception.ServiceAndPriceException;
import com.example.tag.model.ServiceAndPrice;
import com.example.tag.repository.ServiceAndPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceAndPriceServiceImpl implements ServiceAndPriceService {
    private final ServiceAndPriceRepository serviceAndPriceRepository;

    @Transactional
    @Override
    public void addServiceAndPrice(ServiceAndPriceAddRequestModel serviceAndPriceAddRequestModel){
        ServiceAndPrice serviceAndPrice = ServiceAndPrice.builder()
                .username(serviceAndPriceAddRequestModel.getUsername())
                .service(serviceAndPriceAddRequestModel.getService())
                .price(serviceAndPriceAddRequestModel.getPrice())
                .currency(serviceAndPriceAddRequestModel.getCurrency())
                .isNegotiable(serviceAndPriceAddRequestModel.isNegotiable())
                .build();

        serviceAndPriceRepository.save(serviceAndPrice);
    }

    @Transactional
    @Override
    public void updateServiceAndPrice(ServiceAndPriceUpdateRequestModel serviceAndPriceUpdateRequestModel) {
        ServiceAndPrice serviceAndPrice = serviceAndPriceRepository.findByIdAndUsername(serviceAndPriceUpdateRequestModel.getServiceId(),
                serviceAndPriceUpdateRequestModel.getUsername());

        if(serviceAndPrice == null){
            throw new ServiceAndPriceException("Service and price not found");
        }
        serviceAndPrice.setService(serviceAndPriceUpdateRequestModel.getService());
        serviceAndPrice.setPrice(serviceAndPriceUpdateRequestModel.getPrice());
        serviceAndPrice.setCurrency(serviceAndPriceUpdateRequestModel.getCurrency());
        serviceAndPrice.setNegotiable(serviceAndPriceUpdateRequestModel.isNegotiable());

        serviceAndPriceRepository.save(serviceAndPrice);
    }

    @Transactional
    @Override
    public void deleteServiceAndPrice(ServiceAndPriceDeleteRequestModel serviceAndPriceDeleteRequestModel) {
        ServiceAndPrice serviceAndPrice = serviceAndPriceRepository.findByIdAndUsername(serviceAndPriceDeleteRequestModel.getServiceId(),
                serviceAndPriceDeleteRequestModel.getUsername());

        if(serviceAndPrice == null){
            throw new ServiceAndPriceException("Service and price not found");
        }

        serviceAndPriceRepository.delete(serviceAndPrice);
    }

    @Override
    public List<ServiceAndPrice> getServiceAndPrices(String username){
        return serviceAndPriceRepository.findByUsername(username);
    }
}