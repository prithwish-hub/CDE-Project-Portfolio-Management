package com.cts.sharepriceservice.repository;

import com.cts.sharepriceservice.entity.StockDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockDetailsRepo extends JpaRepository<StockDetails, String> {
    Optional<StockDetails> findByName(String name);
}
