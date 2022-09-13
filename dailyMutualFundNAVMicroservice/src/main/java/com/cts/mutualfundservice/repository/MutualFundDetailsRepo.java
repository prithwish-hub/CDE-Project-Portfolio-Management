package com.cts.mutualfundservice.repository;

import com.cts.mutualfundservice.entity.MutualFundDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MutualFundDetailsRepo extends JpaRepository<MutualFundDetails, String> {
    Optional<MutualFundDetails> findByName(String mutualFundName);
}
