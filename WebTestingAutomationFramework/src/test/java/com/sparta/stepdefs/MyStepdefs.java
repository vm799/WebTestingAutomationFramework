package com.sparta.stepdefs;

import com.sparta.pom.pages.HomePage;
import com.sparta.pom.pages.ProductsPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class MyStepdefs {
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";
    private static ChromeDriverService service;
    private static WebDriver webDriver;
    private HomePage homePage;
    private ProductsPage productsPage;

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");
        return chromeOptions;
    }


    @BeforeAll
    public static void beforeAll() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(DRIVER_LOCATION))
                .usingAnyFreePort()
                .build();
        service.start();

    }

    @Before
    public void setup() {
        webDriver = new ChromeDriver(service, getChromeOptions());
    }

    @Given("I am on the automationexercise website homepage")
    public void iAmOnTheAutomationexerciseWebsiteHomepage() {
        homePage = new HomePage(webDriver);
    }

    @When("I click products link")
    public void iClickProductsLink() {
        productsPage = homePage.goToProductsPage();
    }

    @Then("I go to products page")
    public void iGoToProductsPage() {
        Assertions.assertEquals("https://automationexercise.com/products", productsPage.getUrl());
    }

    @Given("I am on the products page")
    public void iAmOnTheProductsPage() {
        homePage = new HomePage(webDriver);
        productsPage = homePage.goToProductsPage();
    }
    @When("type in {string} and click search")
    public void typeInAndClickSearch(String searchProduct) {
        productsPage.enterSearchedProduct(searchProduct);
    }

    @Then("I can see word {string} in the search box")
    public void iCanSeeWordInTheSearchBox(String searchedValue) {
        Assertions.assertEquals(searchedValue, productsPage.getSearchProductValue());
    }

    @After
    void tearDown() {
        webDriver.close();
    }

    @AfterAll
    static void teardownAll() {
        service.stop();
    }


}
