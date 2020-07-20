package ru.appline.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.appline.framework.pages.*;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderingData extends BaseTest{


    Registration registration = new Registration();

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"Стручкова", "Елена", "02.03.1995", "Губин", "Владимир", "11.07.1973", "Петрович", "1234", "567890", "11.07.2018", "РОВД Г.МОСКВА"},
                {"Журкова", "Елена", "02.03.1995", "Губин", "Владимир", "11.07.1973", "Петрович", "1234", "567890", "11.07.2018", "РОВД Г.МОСКВА"},
                {"Седова", "Елена", "02.03.1995", "Губин", "Владимир", "11.07.1973", "Петрович", "1234", "567890", "11.07.2018", "РОВД Г.МОСКВА"},
        });
    }

    @Parameterized.Parameter(0)
    static public String surnameStr;

    @Parameterized.Parameter(1)
    public static String nameStr;

    @Parameterized.Parameter(2)
    public String dateStr;

    @Parameterized.Parameter(3)
    public String surname1Str;

    @Parameterized.Parameter(4)
    public String name1Str;

    @Parameterized.Parameter(5)
    public String date1Str;

    @Parameterized.Parameter(6)
    public String patronymicStr;

    @Parameterized.Parameter(7)
    public String seriesStr;

    @Parameterized.Parameter(8)
    public String numberStr;

    @Parameterized.Parameter(9)
    public String date2Str;

    @Parameterized.Parameter(10)
    public String issueStr;

    @Test
    public void ordering() {

        MainPage mainPage = new MainPage();
        TravelInsurance travelInsurance = new TravelInsurance();
        TravelInsuranceOrder travelInsuranceOrder = new TravelInsuranceOrder();

        // 2. Нажать на – Страхование
        // 3. Выбрать – Страхование путешественников
        mainPage.chainActions();
        // 4. Проверить наличие на странице заголовка – Страхование путешественников
        travelInsurance.findHeader();
        // 5. Нажать на – Оформить Онлайн
        travelInsurance.goToOrderOnline();
        // 6. На вкладке – Выбор полиса выбрать сумму страховой защиты – Минимальная
        // 7. Нажать Оформить
        travelInsuranceOrder.goToOrder();
        //8. На вкладке Оформить заполнить поля:
        //• Фамилию и Имя, Дату рождения застрахованных
        //• Данные страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол
        //• Паспортные данные
        //• Контактные данные не заполняем
        registration.sendKeysAllVars(surnameStr, nameStr, date1Str, surname1Str, name1Str, date1Str, patronymicStr, seriesStr, numberStr, date2Str, issueStr);
        // 9. Проверить, что все поля заполнены правильно
        registration.check(surnameStr, nameStr, date1Str, surname1Str, name1Str, date1Str, patronymicStr, seriesStr, numberStr, date2Str, issueStr);
        // 10. Нажать продолжить
        registration.goToContinue();
        // 11. Проверить, что появилось сообщение - Заполнены не все обязательные поля
        registration.checkError();
    }
}
