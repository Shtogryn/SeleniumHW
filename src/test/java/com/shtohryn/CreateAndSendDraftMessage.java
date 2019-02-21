package com.shtohryn;

import com.opencsv.CSVReader;
import com.shtohryn.bussinessObjects.GmailInboxBO;
import com.shtohryn.bussinessObjects.GmailLoginBO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateAndSendDraftMessage {
    WebDriver webDriver;
    GmailLoginBO gmailLoginBO;
    GmailInboxBO gmailInboxBO;
    static final String URL = "https://www.gmail.com/";

    @BeforeClass
    public void initialSetting() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(URL);
        gmailLoginBO = new GmailLoginBO(webDriver);
        gmailInboxBO = new GmailInboxBO(webDriver);
    }
    @DataProvider(name = "user-data")
    public Object[][] userReciverData() {
        String csvFile = "src/main/resources/user.csv";
        List<Object[]> list = new ArrayList<>();
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object[][] data = new Object[list.size()][];
        return list.toArray(data);
    }

    @Test(dataProvider = "user-data")
    public void test(String email, String password) {
        gmailLoginBO.Authorization(email, password);
        gmailInboxBO.writeAndSaveMessage();
        gmailInboxBO.sendDraft();
    }
}
