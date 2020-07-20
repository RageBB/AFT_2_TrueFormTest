package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registration extends BasePage {

    @FindBy(id = "surname_vzr_ins_0")
    WebElement surname;

    @FindBy(id = "name_vzr_ins_0")
    WebElement name;

    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement date;

    @FindBy(id = "person_lastName")
    WebElement surname1;

    @FindBy(id = "person_firstName")
    WebElement name1;

    @FindBy(id = "person_birthDate")
    WebElement date1;

    @FindBy(id = "person_middleName")
    WebElement patronymic;

    @FindBy(id = "passportSeries")
    WebElement series;

    @FindBy(id = "passportNumber")
    WebElement number;

    @FindBy(id = "documentDate")
    WebElement date2;

    @FindBy(id = "documentIssue")
    WebElement issue;

    @FindBy(xpath = "//*[contains(text(),\"Продолжить\")]")
    WebElement continue1;

    @FindBy(xpath = "//*[@class=\"alert-form alert-form-error\"]")
    WebElement checkError;

    public void sendKeysAllVars(String surname, String name, String date, String surname1, String name1, String date1, String patronymic, String series, String number, String date2, String issue){

        this.surname.sendKeys(surname);
        this.name.sendKeys(name);
        this.date.sendKeys(date);
        this.surname1.click();
        this.surname1.sendKeys(surname1);
        this.name1.sendKeys(name1);
        this.date1.sendKeys(date1);
        this.patronymic.click();
        this.patronymic.sendKeys(patronymic);
        this.series.sendKeys(series);
        this.number.sendKeys(number);
        this.date2.sendKeys(date2);
        this.issue.click();
        this.issue.sendKeys(issue);

    }

    public void check(String surname, String name, String date, String surname1, String name1, String date1, String patronymic, String series, String number, String date2, String issue){

        Assert.assertEquals("Не заполнено", surname, this.surname.getAttribute("value"));
        Assert.assertEquals("Не заполнено", name, this.name.getAttribute("value"));
        Assert.assertEquals("Не заполнено", date, this.date.getAttribute("value"));
        Assert.assertEquals("Не заполнено", surname1, this.surname1.getAttribute("value"));
        Assert.assertEquals("Не заполнено", name1, this.name1.getAttribute("value"));
        Assert.assertEquals("Не заполнено",  date1, this.date1.getAttribute("value"));
        Assert.assertEquals("Не заполнено", patronymic, this.patronymic.getAttribute("value"));
        Assert.assertEquals("Не заполнено", series, this.series.getAttribute("value"));
        Assert.assertEquals("Не заполнено", number, this.number.getAttribute("value"));
        Assert.assertEquals("Не заполнено",  date2, this.date2.getAttribute("value"));
        Assert.assertEquals("Не заполнено", issue, this.issue.getAttribute("value"));
    }

    public void goToContinue(){
    continue1.click();
    }

    public void checkError(){
        Assert.assertEquals("Ошибки нет", "При заполнении данных произошла ошибка", checkError.getText());
    }


}
