package com.sparta.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    }

    @When("I click products link")
    public void iClickProductsLink() {
    }

    @Then("I go to products page")
    public void iGoToProductsPage() {
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
