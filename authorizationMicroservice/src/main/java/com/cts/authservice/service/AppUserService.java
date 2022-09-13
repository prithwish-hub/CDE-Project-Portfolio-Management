package com.cts.authservice.service;

import com.cts.authservice.entity.AppUser;
import com.cts.authservice.entity.AppUserDetails;
import com.cts.authservice.repository.AppUserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with username : " + username));
        log.info("User found with username : {}", username);
        return new AppUserDetails(user);
    }
}
