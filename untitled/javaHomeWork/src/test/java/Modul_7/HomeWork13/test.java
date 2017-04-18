package Modul_7.HomeWork13;

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
 * Created by boltenkov on 06.04.2017.
 */
public class test {
    WebDriver driver;
    @Before
    public void start()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("unexpectedAlertBehaviour","ignore");
        this.driver= new ChromeDriver(caps);
    }

    @Test
    public void Cart()
    {

        this.driver.get("http://localhost:81/lifecart/en/");
        for(int i = 0; i < 3; i ++)
        {
            WebDriverWait wait = new WebDriverWait(this.driver, 5);
            this.driver.findElement(By.cssSelector(".product.column.shadow.hover-light")).click();
            wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.cssSelector(".quantity>button")))).click();
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".quantity"),Integer.toString(1+i)));
            this.driver.navigate().to("http://localhost:81/lifecart/en/");
        }

        this.driver.findElement(By.xpath(".//*[@id='cart']/a[3]")).click();
        if(this.driver.findElement(By.xpath(".//*[@id='box-checkout-cart']/ul/li[1]/a")).isDisplayed())
        {
            this.driver.findElement(By.xpath(".//*[@id='box-checkout-cart']/ul/li[1]/a")).click();
        }
       int i = 0 ;
        do{
            this.driver.manage().timeouts().pageLoadTimeout(1,TimeUnit.SECONDS);
            //int count = this.driver.findElements(By.cssSelector("")).size();
            WebDriverWait wait = new WebDriverWait(this.driver,1,100);


            wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.cssSelector(".item>form>div>p>button[value='Remove']")))).click();
           // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='order_confirmation-wrapper']/table/tbody")));
            i++;
        }while (i<3);

    }

    @After
    public void stop()
    {
        this.driver.quit();
        this.driver = null;
    }
}
