package Modul_11;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by boltenkov on 19.04.2017.
 */
public class MainTest {
    WebDriver driver;
    public static ThreadLocal<App> tlApp = new ThreadLocal<>();
    public App app;

    @Before
    public void start() {


        app = new App();

    }

    @Test
    public void Cart()
    {
        app.workWithTheBasket();
    }

    @After
    public void  quit()
    {
        app.quit();
    }

}
