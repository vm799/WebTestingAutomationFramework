package com.sparta.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver webDriver;
    private By searchProduct = new By.ById("search_product");
    private By searchIcon = new By.ById("submit_search");

    public ProductsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterSearchedProduct(String searchedProduct) {
        var searchedItem = webDriver.findElement(searchProduct);
        searchedItem.sendKeys(searchedProduct);
    }

    public void clickSearch() {
        webDriver.findElement(searchIcon).click();
    }

    public String getSearchProductValue() {
        return webDriver.findElement(searchProduct).getAttribute("value");
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }
}
