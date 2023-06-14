package com.sparta.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver webDriver;
    private final By usernameBy = new By.ByXPath("//input[@placeholder='Email Address']");
    private final By passwordBy = new By.ByXPath("//input[@placeholder='Password']");
    private final By loginButtonBy = new By.ByXPath("//button[text()='Login']");

    private final By messageTextBy = new By.ByTagName("body");
    //  private final By loginButtonBy = new By.ByXPath("//button[text()='login']");


    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public void enterUserName(String username) {
        var userNameBox = webDriver.findElement(usernameBy);
        userNameBox.sendKeys(username);
    }

    public void enterPassword(String password) {
        var passwordBox = webDriver.findElement(passwordBy);
        passwordBox.sendKeys(password);
    }

    public void clickLogin() {
        var loginButton = webDriver.findElement(loginButtonBy);
        loginButton.click();
    }
}