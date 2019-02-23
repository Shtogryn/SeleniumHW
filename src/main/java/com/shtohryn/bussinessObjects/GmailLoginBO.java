package com.shtohryn.bussinessObjects;

import com.shtohryn.entities.User;
import com.shtohryn.pages.LoginPage;
import com.shtohryn.pages.PasswordPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GmailLoginBO {
    WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private User user = new User();

    private static Logger logger = LogManager.getLogger(GmailLoginBO.class);

    public GmailLoginBO(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 10);
        this.loginPage = new LoginPage(webDriver);
        this.passwordPage = new PasswordPage(webDriver);
        logger.info("Successful authorization");
    }

    public void Authorization(String email, String password) {
        loginPage.submitEmail(email);
        passwordPage.submitPassword(password);
    }
}
