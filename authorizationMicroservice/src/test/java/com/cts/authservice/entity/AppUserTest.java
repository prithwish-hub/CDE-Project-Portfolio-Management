package com.cts.authservice.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppUserTest {
    AppUser user = new AppUser();

    @Test
    @DisplayName("Testing if app user class is loading or not")
    void testAppUserLoadingOrNot() {
        assertNotNull(user);
    }

    @Test
    @DisplayName("Testing all the getters and setters")
    void testAllGettersAndSetters() {
        user.setId("U101");
        user.setUsername("Prithwish");
        user.setPassword("1234");

        assertEquals("U101", user.getId());
        assertEquals("Prithwish", user.getUsername());
        assertEquals("1234", user.getPassword());
    }
}