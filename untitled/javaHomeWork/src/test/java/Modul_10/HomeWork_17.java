package Modul_10;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;


/**
 * Created by boltenkov on 16.04.2017.
 */
public class HomeWork_17 {

    WebDriver driver;

    @Before
    public void start() throws MalformedURLException {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        this.driver = new ChromeDriver(cap);


    }


    @Test
    public void openPage()
    {
        this.driver.get("http://localhost:81/lifecart/admin/");
        this.driver.findElement(By.name("username")).clear();
        this.driver.findElement(By.name("username")).sendKeys("admin");
        this.driver.findElement(By.name("password")).clear();
        this.driver.findElement(By.name("password")).sendKeys("admin");
        this.driver.findElement(By.name("login")).click();
        this.driver.navigate().to("http://localhost:81/lifecart/admin/?app=catalog&doc=catalog&category_id=1");
        int count = this.driver.findElements(By.cssSelector(".row")).size();

        for(int i = 0; i < count; i ++)
        {
            try
            {
                this.driver.findElement(By.xpath(".//*[@id='content']/form/table/tbody/tr["+(i+1)+"]/td[3]/img"));
                this.driver.findElement(By.xpath(".//*[@id='content']/form/table/tbody/tr["+(i+1)+"]/td[3]/a")).click();

                this.driver.navigate().back();

            }catch(Exception e)
            {

            }

        }
        List<LogEntry> logPerformance = this.driver.manage().logs().get("performance").getAll();
        List<LogEntry> lolBrowser =this.driver.manage().logs().get("browser").getAll();
        List<LogEntry> logDriver =this.driver.manage().logs().get("driver").getAll();
        List<LogEntry> logClient =this.driver.manage().logs().get("client").getAll();

        if(logPerformance.size()!=0)
        {
            for(LogEntry log:logPerformance)
            {
                System.out.println(log.toString());
            }
        }else{
            System.out.println("Журнал logPerformance пуст");
        }
        if(lolBrowser.size()!=0)
        {
            for(LogEntry log:lolBrowser)
            {
                System.out.println(log.toString());
            }
        }else{
            System.out.println("Журнал lolBrowser пуст");
        }
        if(logClient.size()!=0)
        {
            for(LogEntry log:logClient)
            {
                System.out.println(log.toString());
            }
        }else{
            System.out.println("Журнал logClient пуст");
        }
        if(logDriver.size()!=0)
        {
            for(LogEntry log:logDriver)
            {
                System.out.println(log.toString());
            }
        }else{
            System.out.println("Журнал logDriver пуст");
        }




//




    }
    @After
    public void stop()
    {
        this.driver.close();
        this.driver = null;
    }
}
