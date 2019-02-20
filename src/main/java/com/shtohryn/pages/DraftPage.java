package com.shtohryn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DraftPage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    @FindBy(css = "#\\3a be")
    private WebElement lastMessage;
    @FindBy(xpath = "//div[@class='AD']//tr[@class='btC']/td/div/div[@role='button']")
    WebElement sendButtom;

    public DraftPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriverWait = new WebDriverWait(webDriver, 15);
    }

    public void openDraft() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#\\3a be")));
        lastMessage.click();
    }

    public void sendDraft() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='Ha']")));
        sendButtom.click();
    }
}
