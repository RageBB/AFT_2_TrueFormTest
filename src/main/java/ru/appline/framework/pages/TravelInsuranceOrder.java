package ru.appline.framework.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class TravelInsuranceOrder extends BasePage {

    @FindBy(xpath = "/html/body/app/ng-component/div/div/div/app-setup-product/div/form/div/fieldset[5]/div/div/online-card-program/div")
    private WebElement sumMin;

    @FindBy(xpath = "//*[contains(text(),\"Оформить\")]")
    private WebElement order;

    public void goToOrder() {
        order.click();
    }

}
