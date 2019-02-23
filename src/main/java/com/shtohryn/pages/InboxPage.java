package com.shtohryn.pages;

import com.shtohryn.webElements.Button;
import com.shtohryn.webElements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPage {
    WebDriver webDriver;
    private WebDriverWait webDriverWait;
    @FindBy(xpath = "//div[text()='Compose']")
    private WebElement buttonCompose;
    @FindBy(xpath = "//form[@class='bAs']//textarea[@name='to']")
    private WebElement textAreaTo;
    @FindBy(xpath = "//form/div/input[@name='subjectbox']")
    private WebElement subjectbox;
    @FindBy(xpath = "//div[@class='AD']//td/div/div[@role='textbox']")
    private WebElement messageTextArea;
    @FindBy(xpath = "//img[@class='Ha']")
    private WebElement sendButtom;
    @FindBy(css = "*[href*='#drafts'")
    private WebElement draftButton;

    public InboxPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriverWait = new WebDriverWait(webDriver, 20);
    }

    public void saveMessage(String message, String email, String purpose) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Compose']")));
        buttonCompose.click();
        textAreaTo.sendKeys(email);
        subjectbox.sendKeys(purpose);
        messageTextArea.sendKeys(message);
        sendButtom.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*[href*='#drafts'")));
    }

    public void enterDrafts() {
        draftButton.click();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public WebElement getButtonCompose() {
        return buttonCompose;
    }

    public WebElement getTextAreaTo() {
        return textAreaTo;
    }

    public WebElement getSubjectbox() {
        return subjectbox;
    }

    public WebElement getMessageTextArea() {
        return messageTextArea;
    }

    public WebElement getSendButtom() {
        return sendButtom;
    }

    public WebElement getDraftButton() {
        return draftButton;
    }
}
