package com.sparta.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver webDriver;
    private By addToCart = new By.ByCssSelector("a[data-product-id='1']");
    private By chooseItem = new By.ByXPath("//*[text()='Blue Top']");
    private By itemAddedMessage = new By.ById("cartModal");
    private By deleteItem = new By.ByClassName("cart_delete");
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
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(itemAddedMessage));

        String text = webDriver.findElement(By.cssSelector(".modal-title.w-100")).getAttribute("innerHTML");
        System.out.println(text);
        return text;
    }

    public void removeItem() {
        webDriver.findElement(deleteItem).click();
    }

    public boolean cartEmpty() {
        return webDriver.findElement(itemRemoved).isDisplayed();
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

}