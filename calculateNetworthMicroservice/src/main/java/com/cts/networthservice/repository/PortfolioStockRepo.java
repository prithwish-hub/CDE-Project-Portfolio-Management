package com.cts.networthservice.repository;

import com.cts.networthservice.entity.PortfolioStockDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PortfolioStockRepo extends JpaRepository<PortfolioStockDetails, String> {
    @Query("SELECT p FROM PortfolioStockDetails p WHERE p.portfolioDetails.id = ?1 AND p.stockName = ?2")
    PortfolioStockDetails getCurrentStockStatus(String portfolio_id, String stockName);

    @Modifying
    @Query("UPDATE PortfolioStockDetails p SET p.stockCount = ?3 WHERE p.portfolioDetails.id = ?1 AND p.stockName = ?2")
    void updateStockStatus(String portfolio_id, String stockName, int volume);

    @Modifying
    @Query("DELETE PortfolioStockDetails p WHERE p.portfolioDetails.id = ?1 AND p.stockName = ?2")
    void deleteStockRecord(String portfolio_id, String stockName);
}
