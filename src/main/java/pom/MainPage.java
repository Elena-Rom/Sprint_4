package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {


    public static final String URL = "https://qa-scooter.praktikum-services.ru";

    private final WebDriver webDriver;

    //Кнопка "Заказть" вверху
    private final By orderButtonUp = By.xpath(".//button[@class='Button_Button__ra12g']");
    //Кнопка "Заказать" внизу
    private final By orderButtonDown = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //таблица с вопросами
    private final By intoView = By.cssSelector("div[role=button]");
    //текст
    private final By textGet = By.cssSelector("div[role=region]");


    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public MainPage open() {
        webDriver.get(URL);
        return this;
    }

    public MainPage clickOrderUp() {
        webDriver.findElement(orderButtonUp).click();
        return this;
    }

    public MainPage clickOrderDown() {
        WebElement element = webDriver.findElement(orderButtonDown);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        return this;
    }

    public MainPage clickQuestionAboutImportant(int index) {
        WebElement element = webDriver.findElements(intoView).get(index);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        return this;
    }


    public String getAnswer(int index) {
        return webDriver.findElements(textGet).get(index).getText();
    }

}