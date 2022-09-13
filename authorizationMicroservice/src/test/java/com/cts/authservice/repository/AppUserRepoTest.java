package com.cts.authservice.repository;

import com.cts.authservice.entity.AppUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class AppUserRepoTest {
    @MockBean
    AppUserRepo appUserRepo;

    @Test
    @DisplayName("Testing if findByUsername method is working or not")
    void testFindByUsername() {
        AppUser appUser = new AppUser("U101", "Prithwish", "1234");
        when(appUserRepo.findByUsername("Prithwish")).thenReturn(Optional.of(appUser));
        assertEquals(Optional.of(appUser), appUserRepo.findByUsername("Prithwish"));
    }
}