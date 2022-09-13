package com.cts.networthservice.repository;

import com.cts.networthservice.entity.PortfolioMutualFundDetails;
import com.cts.networthservice.entity.PortfolioStockDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PortfolioMutualFundRepo extends JpaRepository<PortfolioMutualFundDetails, String> {
    @Query("SELECT p FROM PortfolioMutualFundDetails p WHERE p.portfolioDetails.id = ?1 AND p.mutualFundName = ?2")
    PortfolioMutualFundDetails getCurrentMutualFundStatus(String portfolio_id, String mutualFundName);

    @Modifying
    @Query("UPDATE PortfolioMutualFundDetails p SET p.mutualFundUnits = ?3 WHERE p.portfolioDetails.id = ?1 AND p.mutualFundName = ?2")
    void updateMutualFundStatus(String portfolio_id, String mutualFundName, int volume);

    @Modifying
    @Query("DELETE PortfolioMutualFundDetails p WHERE p.portfolioDetails.id = ?1 AND p.mutualFundName = ?2")
    void deleteCurrentMutualFund(String portfolio_id,String mutualFundName);
}
