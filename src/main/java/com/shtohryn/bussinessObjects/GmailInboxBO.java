package com.shtohryn.bussinessObjects;

import com.shtohryn.entities.Message;
import com.shtohryn.entities.User;
import com.shtohryn.pages.DraftPage;
import com.shtohryn.pages.InboxPage;
import org.openqa.selenium.WebDriver;

public class GmailInboxBO {
    private WebDriver webDriver;
    private InboxPage inboxPage;
    private DraftPage draftPage;
    private User user = new User();
    private Message message = new Message();

    public GmailInboxBO(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.inboxPage = new InboxPage(webDriver);
        this.draftPage = new DraftPage(webDriver);
        this.user = user;
        this.message = message;
    }

    public void writeAndSaveMessage() {
        inboxPage.saveMessage(message.getMessage(), message.getEmail(), message.getSubject());
        inboxPage.enterDrafts();
    }

    public void sendDraft() {
        draftPage.sendDraft();
    }
}
