package com.shtohryn;

import com.shtohryn.bussinessObjects.GmailInboxBO;
import com.shtohryn.bussinessObjects.GmailLoginBO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAndSendDraftMessage {
    WebDriver webDriver;
    GmailLoginBO gmailLoginBO;
    GmailInboxBO gmailInboxBO;
    static final String URL = "https://www.gmail.com/";

    @BeforeEach
    public void initialSetting() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(URL);
        gmailLoginBO = new GmailLoginBO(webDriver);
        gmailInboxBO = new GmailInboxBO(webDriver);
    }

    @Test
    public void test() {
        gmailLoginBO.Authorization();
        gmailInboxBO.writeAndSaveMessage();
        gmailInboxBO.sendDraft();
    }
}
