package ru.appline.framework.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.framework.util.DriverManager;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public boolean isElementPresent(By by) {
        try {
            ru.appline.framework.util.DriverManager.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            ru.appline.framework.util.DriverManager.getDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
        finally {
            ru.appline.framework.util.DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            ru.appline.framework.util.DriverManager.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        finally {
            ru.appline.framework.util.DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void click(WebElement element) {
        ((JavascriptExecutor) ru.appline.framework.util.DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(false);", element);
        Wait<WebDriver> wait = new WebDriverWait(ru.appline.framework.util.DriverManager.getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

}
