package br.com.harisson.devdojotest.util;

import br.com.harisson.devdojotest.model.ApplicationUser;

import java.util.List;

public class ApplicationUserCreator {
    public static ApplicationUser createValidApplicationUser(){
        return ApplicationUser.builder()
                .accountId(1L)
                .password("123")
                .userKey("8a85867e6ad9e761016ada958bdf5b0f")
                .role("USER")
                .username("Harisson")
                .build();
    }
    public static List<ApplicationUser> createValidListApplicationUser(){
        return List.of(createValidApplicationUser());
    }
}
