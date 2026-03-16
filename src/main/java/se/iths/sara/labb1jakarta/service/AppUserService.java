package se.iths.sara.labb1jakarta.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import se.iths.sara.labb1jakarta.entity.AppUser;
import se.iths.sara.labb1jakarta.repository.AppUserRepository;

import java.util.List;

@ApplicationScoped
public class AppUserService {

    @Inject
    private AppUserRepository appUserRepository;

    @Transactional
    public AppUser saveUser(AppUser user) {
        return appUserRepository.save(user);
    }

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    public AppUser login(String username, String password) {

        AppUser user = appUserRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}