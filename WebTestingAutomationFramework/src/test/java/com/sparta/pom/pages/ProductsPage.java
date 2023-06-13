package com.sparta.pom.pages;

import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver webDriver;

    public ProductsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }
}
