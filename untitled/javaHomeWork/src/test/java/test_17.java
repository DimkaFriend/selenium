import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

/**
 * Created by boltenkov on 16.04.2017.
 */
public class test_17 {
    EventFiringWebDriver driver;

    @Before
    public void start() throws MalformedURLException {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
       this.driver = new EventFiringWebDriver(new ChromeDriver(cap));
        this.driver.register(new WebDriverEventListener() {
            @Override
            public void beforeAlertAccept(WebDriver driver) {

            }

            @Override
            public void afterAlertAccept(WebDriver driver) {

            }

            @Override
            public void afterAlertDismiss(WebDriver driver) {

            }

            @Override
            public void beforeAlertDismiss(WebDriver driver) {

            }

            @Override
            public void beforeNavigateTo(String url, WebDriver driver) {
                System.out.println(url +" "+ driver);
            }

            @Override
            public void afterNavigateTo(String url, WebDriver driver) {

            }

            @Override
            public void beforeNavigateBack(WebDriver driver) {

            }

            @Override
            public void afterNavigateBack(WebDriver driver) {

            }

            @Override
            public void beforeNavigateForward(WebDriver driver) {

            }

            @Override
            public void afterNavigateForward(WebDriver driver) {

            }

            @Override
            public void beforeNavigateRefresh(WebDriver driver) {

            }

            @Override
            public void afterNavigateRefresh(WebDriver driver) {

            }

            @Override
            public void beforeFindBy(By by, WebElement element, WebDriver driver) {
                System.out.println(by+" "+element+" "+ driver);
            }

            @Override
            public void afterFindBy(By by, WebElement element, WebDriver driver) {

            }

            @Override
            public void beforeClickOn(WebElement element, WebDriver driver) {

            }

            @Override
            public void afterClickOn(WebElement element, WebDriver driver) {

            }

            @Override
            public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

            }

            @Override
            public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

            }

            @Override
            public void beforeScript(String script, WebDriver driver) {

            }

            @Override
            public void afterScript(String script, WebDriver driver) {

            }

            @Override
            public void onException(Throwable throwable, WebDriver driver) {

            }
        });
    }
    @Test
    public void openPage()
    {

        this.driver.get("http://docs.selenium2.ru");
        this.driver.manage().logs().get("performance").forEach(l -> System.out.println(l));
        System.out.println(this.driver.manage().logs().getAvailableLogTypes());
        this.driver.manage().logs().get("performance");
        this.driver.manage().logs().get("browser");
        this.driver.manage().logs().get("driver");
        this.driver.manage().logs().get("client");

//

        if((this.driver.manage().logs().get("browser").toString()==null)&&(this.driver.manage().logs().get("browser").toString()==""))
        {
            System.out.println("Список логов клиента пуст");
        }else{
            this.driver.manage().logs().get("browser").forEach(l ->{System.out.println(l);System.out.println("1");} );
        }
//        if(this.driver.manage().logs().get("client").getAll()==null)
//        {
//            System.out.println("Список логов клиента пуст");
//        }else{
//            this.driver.manage().logs().get("client").forEach(l -> System.out.println(l));
//        }
//        if(this.driver.manage().logs().get("driver").getAll()==null)
//        {
//            System.out.println("Список логов драйвера пуст");
//        }else{
//            this.driver.manage().logs().get("driver").forEach(l -> System.out.println(l));
//        }
//        if(this.driver.manage().logs().get("performance").getAll()==null)
//        {
//            System.out.println("Список логов performance пуст");
//        }else{
//            this.driver.manage().logs().get("performance").forEach(l -> System.out.println(l));
//        }

    }
    @After
    public void stop()
    {
        this.driver.close();
        this.driver = null;
    }
}
