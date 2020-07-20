package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.framework.util.DriverManager;

public class TravelInsurance extends BasePage {

    @FindBy(xpath = "//*[@id=\"main\"]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/h1")
    private WebElement insuranceTravelerHeader;

    @FindBy(xpath = "//*[contains(text(),\"Оформить онлайн\") and @class=\"kit-button__text\"]")
    private WebElement goToOrderOnline;

    public void findHeader(){
        DriverManager.getDriver();
        Assert.assertEquals("Отсутствует заголовок - Страхование путешественников", "Страхование путешественников", insuranceTravelerHeader.getText());
    }

    public void goToOrderOnline(){
        goToOrderOnline.click();
    }

}
