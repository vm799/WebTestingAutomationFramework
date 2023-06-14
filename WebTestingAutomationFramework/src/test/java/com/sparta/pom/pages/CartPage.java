package com.sparta.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver webDriver;
    private By addToCart = new By.ByCssSelector("a[data-product-id='1']");
    private By chooseItem = new By.ByXPath("//*[text()='Blue Top']");
    private By itemAddedMessage = new By.ById("cartModal");
    private By deleteItem = new By.ByClassName("cart_quantity_delete");
    private By itemRemoved = new By.ById("empty_cart");

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void onCartPage() {
        webDriver.get("https://automationexercise.com/view_cart");
    }

    public void clickAddToCart() {
        webDriver.findElement(addToCart).click();
    }

    public void chooseProduct() {
        webDriver.findElement(chooseItem);
    }

    public boolean hasMessage(String message) {
       String text = webDriver.findElement(itemAddedMessage).getText();
        return text.contains(message);
    }

    public void removeItem() {
        webDriver.findElement(deleteItem).click();
    }

    public boolean confirmRemove(String message) {
        String text = webDriver.findElement(itemRemoved).getText();
        return text.contains(message);
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

}
