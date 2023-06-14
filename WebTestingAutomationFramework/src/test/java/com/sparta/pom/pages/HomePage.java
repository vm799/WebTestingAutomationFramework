package com.sparta.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver webDriver;
    private By productsLink = new By.ByXPath("//a[@href='/products']");
    private By cartLink = new By.ByXPath("//a[@href='/view_cart']");
    private By loginLink = new By.ByLinkText("Signup / Login");
    private final By messageTextBy = new By.ByTagName("body");
    private final By loggedIn = new By.ByClassName("fa-user");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        goToHomePage();
    }

    private void goToHomePage() {
        webDriver.get("https://automationexercise.com/");
    }

    public ProductsPage goToProductsPage() {
        webDriver.findElement(productsLink).click();
        return new ProductsPage(webDriver);
    }

    public CartPage gotToCartPage() {
        webDriver.findElement(cartLink).click();
        return new CartPage(webDriver);
    }

    public LoginPage goToLoginPage() {
        webDriver.findElement(loginLink).click();
        return new LoginPage(webDriver);
    }
    public LogoutPage goToLogoutPage() {
        webDriver.get("https://automationexercise.com/");
        return new LogoutPage(webDriver);
    }

    public boolean hasMessage(String message) {
        String bodyText = webDriver.findElement(messageTextBy).getText();
        System.out.println(bodyText);
        return bodyText.contains(message);
    }


}
