package ru.appline.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.appline.framework.util.DriverManager;
import ru.appline.framework.util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class BaseTest {

    private static String baseUrl;
    private static Properties properties = TestProperties.getInstance().getProperties();

    @Before
    public void setUp() {
        baseUrl = properties.getProperty("app.url");
        DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(baseUrl);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
