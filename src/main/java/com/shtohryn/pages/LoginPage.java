package com.shtohryn.pages;

import com.shtohryn.webElements.Button;
import com.shtohryn.webElements.InputField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver webDriver;
    @FindBy(css = "input[type='email']")
    private WebElement emailField;
    @FindBy(xpath = "//div[@class=\'dG5hZc\']//span")
    private WebElement buttonNext;

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void submitEmail(String email) {
        emailField.sendKeys(email);
        buttonNext.click();

    }
}
