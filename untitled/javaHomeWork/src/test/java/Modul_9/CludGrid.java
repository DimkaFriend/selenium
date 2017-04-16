package Modul_9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by boltenkov on 16.04.2017.
 */
public class CludGrid {
    WebDriver driver;

    @Before
    public void start() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("unexpectedAlertBehaviour","ignore");
        this.driver= new RemoteWebDriver(new URL("http://192.168.0.121:4444/wd/hub"),DesiredCapabilities.chrome());


    }
    @Test
    public void openPage()
    {
        this.driver.get("http://docs.seleniumhq.org/docs/04_webdriver_advanced.jsp");
    }
    @After
    public void stop()
    {
        this.driver.close();
        this.driver = null;
    }
}
