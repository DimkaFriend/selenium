package Modul_11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by boltenkov on 19.04.2017.
 */
public class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        this.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        this.driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
    }
}
//fork
