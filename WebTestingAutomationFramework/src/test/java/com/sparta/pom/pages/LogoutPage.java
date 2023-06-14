package com.sparta.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    private WebDriver webDriver;
    private By logoutLink = new By.ByLinkText("Logout");
    public LogoutPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public void clickLogout() {
        webDriver.findElement(logoutLink).click();
    }
}