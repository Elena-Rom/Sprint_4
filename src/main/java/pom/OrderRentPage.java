package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderRentPage {

    private final WebDriver webDriver;



    //Поле выбора даты аренды
    private final By dateInput = By.xpath(".//div[@class='react-datepicker__input-container']");
    //календарь
    private final By windowCalendar = By.xpath(".//div[@class='react-datepicker__month-container']");
    //Дата
    private final By dateChoice = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--006']");
    //Кнопка раскрыть список
    private final By buttonDropdown = By.xpath(".//div/span[@class='Dropdown-arrow']");
    //Окно со писком срока аренды
    private final By windowDropDown = By.xpath(".//div[@class='Dropdown-menu']");
    //Срок аренды
    private final By rentalPeriod = By.xpath(".//div[@class='Dropdown-option' and text()= 'сутки']");
    //Выбор Цвета самоката
    private final By colorChoice = By.xpath(".//input[@id='black']");
    //Поле комментария для курьера
    private final By commentInput = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    //Кнопка Заказать
    private final By buttonOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Окно подтверждения .//div[text()='Хотите оформить заказ?']
    private final By windowOk = By.xpath(".//div[@class='Order_Modal__YZ-d3']");
    //Кнопка Да
    private final By buttonOk = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    //Окно Заказ оформлен
    private final By windowOrderSuccessfully = By.xpath(".//div[text()='Заказ оформлен']");


    public OrderRentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public OrderRentPage choiceDateForOrder() {
        webDriver.findElement(dateInput).click();
        if (webDriver.findElement(windowCalendar).isDisplayed()){
            webDriver.findElement(dateChoice).click();
        }
        return this;
    }

    public OrderRentPage choiceRentalPeriod() {
        webDriver.findElement(buttonDropdown).click();
        if (webDriver.findElement(windowDropDown).isDisplayed()){
            webDriver.findElement(rentalPeriod).click();
        }
        return this;
    }

    public OrderRentPage choiceColorScooter(){
        webDriver.findElement(colorChoice).click();
        return this;
    }

    public OrderRentPage commentForDelivery(String comment){
        webDriver.findElement(commentInput).sendKeys(comment);
        return this;
    }

    public OrderRentPage orderClick(){
        webDriver.findElement(buttonOrder).click();
        if(webDriver.findElement(windowOk).isDisplayed()){
            webDriver.findElement(buttonOk).click();
        }
        return this;
    }

    public OrderRentPage checkShowOrder(){
        webDriver.findElement(windowOrderSuccessfully);
        return this;
    }


}
