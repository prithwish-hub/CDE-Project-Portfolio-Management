package com.cts.mutualfundservice.service;

import com.cts.mutualfundservice.clients.AuthFeignClient;
import com.cts.mutualfundservice.entity.MutualFundDetails;
import com.cts.mutualfundservice.exception.InvalidJwtTokenException;
import com.cts.mutualfundservice.exception.MutualFundNotFoundException;
import com.cts.mutualfundservice.repository.MutualFundDetailsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MutualFundService {

    @Autowired
    private MutualFundDetailsRepo mutualFundDetailsRepo;
    @Autowired
    private AuthFeignClient authFeignClient;

    public ResponseEntity<MutualFundDetails> getMutualFundDetailsByName(String jwtToken, String mutualFundName) throws MutualFundNotFoundException, InvalidJwtTokenException {
        if (authFeignClient.validate(jwtToken).getBody().isValid()) {
            MutualFundDetails mutualFundDetails = mutualFundDetailsRepo.findByName(mutualFundName)
                    .orElseThrow(() -> new MutualFundNotFoundException("No mutual fund found with name : " + mutualFundName));
            log.info("Mutual Fund details found");
            log.debug("Mutual Fund details : {}", mutualFundDetails);
            return ResponseEntity.ok(mutualFundDetails);
        }
        log.error("Jwt token is not valid");
        throw new InvalidJwtTokenException("Jwt token is not valid");
    }

}
