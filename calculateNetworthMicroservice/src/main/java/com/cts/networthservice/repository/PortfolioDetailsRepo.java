package com.cts.networthservice.repository;

import com.cts.networthservice.entity.PortfolioDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortfolioDetailsRepo extends JpaRepository<PortfolioDetails, String> {
    Optional<PortfolioDetails> findByUserId(String userId);
}
