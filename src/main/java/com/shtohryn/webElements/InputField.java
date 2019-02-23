package com.shtohryn.webElements;

import org.openqa.selenium.WebElement;

public class InputField extends Element implements WebElement {
    public InputField(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(int limitChars, CharSequence... arg0) {
    }

    public String getEmail() {
        return super.getAttribute("email");
    }

    public String getValue() {
        return super.getAttribute("value");
    }
}
