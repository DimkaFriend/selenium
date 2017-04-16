package Modul_9;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by boltenkov on 16.04.2017.
 */
public class Grid {
    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void start()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("unexpectedAlertBehaviour","ignore");
        this.driver= new ChromeDriver(caps);
        wait= new WebDriverWait(this.driver,5);
    }
    @After
    public void stop()
    {
        this.driver.quit();
        this.driver = null;
    }
}
