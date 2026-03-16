package se.iths.sara.labb1jakarta.web;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import se.iths.sara.labb1jakarta.entity.AppUser;
import se.iths.sara.labb1jakarta.service.AppUserService;

import java.io.Serializable;

@Named
@SessionScoped
public class AppUserloginBean implements Serializable {

    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;

    @Getter
    private AppUser loggedInUser;

    @Getter
    private String errorMessage;

    @Inject
    private AppUserService appUserService;

    public String login() {

        loggedInUser = appUserService.login(username, password);

        if (loggedInUser != null) {
            errorMessage = null;
            return "appUser-chat.xhtml?faces-redirect=true";
        }

        errorMessage = "Fel användarnamn eller lösenord";
        return null;
    }

    public String logout() {
        loggedInUser = null;
        username = null;
        password = null;
        errorMessage = null;
        return "appUser-login.xhtml?faces-redirect=true";
    }

}