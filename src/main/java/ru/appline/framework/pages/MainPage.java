package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.appline.framework.util.DriverManager;

public class MainPage extends BasePage{

    private Actions actions;

    @FindBy(xpath = "//*[contains(text(),\"Страхование\") and @class=\"lg-menu__text\"]")
    private WebElement insurance;

    @FindBy(xpath = "//*[@id=\"submenu-5\"]/div/div/div[1]/ul/li[3]/a")
    private WebElement insuranceTraveler;

    public void chainActions(){
        actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(insurance).moveToElement(insuranceTraveler).click().build().perform();
    }
}
