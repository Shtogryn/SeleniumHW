package com.shtohryn.webElements;

import org.openqa.selenium.WebElement;

public class TextField extends Element implements WebElement {
    public TextField(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(int limitChars, CharSequence... arg0) {
    }
}
