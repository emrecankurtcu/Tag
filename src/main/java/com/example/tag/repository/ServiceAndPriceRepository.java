package com.example.tag.repository;

import com.example.tag.model.ServiceAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceAndPriceRepository extends JpaRepository<ServiceAndPrice, Integer> {
    ServiceAndPrice findByIdAndUsername(int id, String username);

    List<ServiceAndPrice> findByUsername(String username);
}
