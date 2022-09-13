package com.cts.authservice.repository;

import com.cts.authservice.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, String> {
    Optional<AppUser> findByUsername(String username);
}
