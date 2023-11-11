package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderUserPage {
    private final WebDriver webDriver;

    //Поле ввода имени
    private final By nameInput = By.xpath(".//div[2]/div[1]/input");
    //Поле ввода фамилии
    private final By lastNameInput = By.xpath(".//div[2]/div[2]/input");
    //Поле ввода адреса
    private final By addressInput = By.xpath(".//div[2]/div[3]/input");
    //Поле ввода станции метро
    private final By stationChoice = By.xpath(".//div/input[@class='select-search__input']");
    //Окно с выпадающим списком
    private final By windowWithStation = By.xpath(".//div[@class='select-search__select']");
    //Станция метро
    private final By station = By.xpath(".//button/div[text()='Сокольники']");

    //Поле ввода номера телефона
    private final By numberInput = By.xpath(".//div[2]/div[5]/input");
    //Кнопка Далее
    private final By nextButton = By.xpath(".//button[text()='Далее']");

    //Форма ввода заказа
    private final By formOrder = By.xpath(".//div[@class='Order_Form__17u6u']");

    public OrderUserPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public OrderUserPage nameForOrderInput(String Name) {
        webDriver.findElement(nameInput).sendKeys(Name);
        return this;
    }

    public OrderUserPage lastNameForOrderInput(String LastName) {
        webDriver.findElement(lastNameInput).sendKeys(LastName);
        return this;
    }

    public OrderUserPage addressForOrderInput(String Address) {
        webDriver.findElement(addressInput).sendKeys(Address);
        return this;
    }

    public OrderUserPage stationForOrderInput() {
        webDriver.findElement(stationChoice).click();
        if (webDriver.findElement(windowWithStation).isEnabled()){
            webDriver.findElement(station).click();
        }
        return this;
    }

    public OrderUserPage numberForOrderInput(String number) {
        webDriver.findElement(numberInput).sendKeys(number);
        return this;
    }

    public OrderUserPage buttonClickNext(){
        webDriver.findElement(nextButton).click();
        return this;
    }

    public boolean checkShowForm() {
        return webDriver.findElement(formOrder).isDisplayed();
    }

}
