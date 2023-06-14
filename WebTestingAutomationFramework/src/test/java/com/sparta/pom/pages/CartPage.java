package com.sparta.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class CartPage {

    private WebDriver webDriver;
    private By addToCart = new By.ByCssSelector("a[data-product-id='1']");
    private By chooseItem = new By.ByXPath("//*[text()='Blue Top']");
    private By itemAddedMessage = new By.ByXPath("");
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
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement element = webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(chooseItem)));

        Actions actions = new Actions(webDriver);
        actions.scrollByAmount(0, 500);
        actions.perform();

    }

    public String hasMessage(String message) {
        String text = webDriver.findElement(itemAddedMessage).toString();
        System.out.println(text);
       return text;
//        return text.contains(message);
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
