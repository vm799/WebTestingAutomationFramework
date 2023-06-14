package com.sparta.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver webDriver;
    private By productsLink = new By.ByXPath("//a[@href='/products']");
    private By cartLink = new By.ByXPath("//a[@href='/view_cart']");

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

}
