package com.shtohryn.bussinessObjects;

import com.shtohryn.entities.User;
import com.shtohryn.pages.LoginPage;
import com.shtohryn.pages.PasswordPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginBO {
    WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private User user = new User();

    public GmailLoginBO(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 10);
        this.loginPage = new LoginPage(webDriver);
        this.passwordPage = new PasswordPage(webDriver);
    }

    public void Authorization() {
        loginPage.submitEmail(user.getEmail());
        passwordPage.submitPassword(user.getPassword());
    }
}
