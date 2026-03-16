package se.iths.sara.labb1jakarta.repository;

import se.iths.sara.labb1jakarta.entity.AppUser;

import java.util.List;

public interface AppUserRepository {
    AppUser save(AppUser appUser);

    AppUser findByUsername(String username);

    List<AppUser> findAll();
}
