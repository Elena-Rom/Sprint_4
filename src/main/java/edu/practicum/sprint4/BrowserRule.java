package edu.practicum.sprint4;

import org.junit.After;
import org.junit.Before;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BrowserRule extends ExternalResource{

    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Before
    public void before() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @After
    public void after() {
        webDriver.quit();
    }
}


