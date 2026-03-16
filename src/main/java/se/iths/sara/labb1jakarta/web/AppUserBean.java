package se.iths.sara.labb1jakarta.web;


import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import se.iths.sara.labb1jakarta.entity.AppUser;
import se.iths.sara.labb1jakarta.service.AppUserService;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped

public class AppUserBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private AppUserService appUserService;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;

    public List<AppUser> getAppUsers() {
        return appUserService.getAllUsers();
    }

    public void saveAppUser() {
        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        appUser.setPassword(password);

        appUserService.saveUser(appUser);
        username = "";
        password = "";
    }

}
