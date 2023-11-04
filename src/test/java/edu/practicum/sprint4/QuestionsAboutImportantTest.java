package edu.practicum.sprint4;

import org.junit.Rule;
import org.junit.Test;
import pom.MainPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuestionsAboutImportantTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();


    private final String answer;
    private final int index;

    public QuestionsAboutImportantTest(String answer, int index) {
        this.answer = answer;
        this.index = index;
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][]{

                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6}


        };
    }

    @Test
    public void questionAbout() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        mainPage.open();
        mainPage.clickQuestionAboutImportant(index);

        assertEquals(answer, mainPage.getAnswer(index));

    }
}