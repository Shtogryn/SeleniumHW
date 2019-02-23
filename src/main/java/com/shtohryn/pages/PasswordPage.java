package com.shtohryn.pages;

import com.shtohryn.webElements.Button;
import com.shtohryn.webElements.InputField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordPage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    @FindBy(css = "input[type='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//div[@id='passwordNext']")
    private WebElement buttonNext;

    public PasswordPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriverWait = new WebDriverWait(webDriver, 10);
    }

    public void submitPassword(String password) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.sendKeys(password);
        buttonNext.click();
    }
}
