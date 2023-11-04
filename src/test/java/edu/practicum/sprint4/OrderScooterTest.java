package edu.practicum.sprint4;

import org.junit.Rule;
import org.junit.Test;
import pom.MainPage;
import pom.OrderRentPage;
import pom.OrderUserPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderScooterTest {

    private static final String RESULT_TEXT_TRUE = "Заказ оформлен";

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void orderUpScooterTrue() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        OrderRentPage orderRent = new OrderRentPage(browserRule.getWebDriver());
        OrderUserPage orderUser = new OrderUserPage(browserRule.getWebDriver());


        mainPage
                .open()
                .clickOrderUp();
        orderUser
                .nameForOrderInput("Имя")
                .lastNameForOrderInput("Фамилия")
                .addressForOrderInput("Адрес 55")
                .stationForOrderInput()
                .numberForOrderInput("89213459878")
                .buttonClickNext();
        orderRent
                .choiceDateForOrder()
                .choiceRentalPeriod()
                .choiceColorScooter()
                .commentForDelivery("Комментарий")
                .orderClick();

        assertEquals(RESULT_TEXT_TRUE, orderRent.checkShowOrder().toString());
    }

    @Test
    public void orderDownScooterTrue() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        OrderUserPage orderUser = new OrderUserPage(browserRule.getWebDriver());

        mainPage
                .open()
                .clickOrderDown();

        assertTrue("Форма заказала не отобразилась",
                orderUser.checkShowForm());
    }

}
