package Modul_6.HomeWork11.HomeWork11.HomeWork11;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by boltenkov on 02.04.2017.
 */
public class testGoogle {
    WebDriver driver;

    String FirstName;
    String LastName;
    String Address1;
    String Address2;
    String Postcode;
    String City ;
    String Email ;
    String Phone ;
    String Password ;

    @Before
    public void start()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("unexpectedAlertBehaviour","ignore");
        this.driver= new ChromeDriver(caps);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void createAccaunt()
    {
        Date d = new Date();
        String FirstName ="Дима" + d.getTime();
        String LastName ="Frend" + d.getTime();
        String Address1 =""+d.getTime();
        String Address2= ""+d.getTime();
        String Postcode = "00210";
        String City ="Portsmouth";
        String Email ="EKB"+d.getTime()+"@mail.ru";
        String Phone = "+1111111111";
        String Password ="sasorysan" ;

        this.driver.get("http://localhost:81/lifecart/");
        this.driver.findElement(By.cssSelector(".content>form>table>tbody>tr>td>a")).click();
        //this.driver.findElement(By.cssSelector(".content>form>table>tbody>tr>td>a")).click();
        if(this.driver.findElements(By.cssSelector(".content>form>table>tbody>tr>td>input"))!=null)
        {
            this.driver.findElements(By.cssSelector(".content>form>table>tbody>tr>td>input")).get(2).sendKeys(FirstName);
            this.driver.findElements(By.cssSelector(".content>form>table>tbody>tr>td>input")).get(3).sendKeys(LastName);
            this.driver.findElements(By.cssSelector(".content>form>table>tbody>tr>td>input")).get(4).sendKeys(Address1);
            this.driver.findElements(By.cssSelector(".content>form>table>tbody>tr>td>input")).get(5).sendKeys(Address2);
            this.driver.findElements(By.cssSelector(".content>form>table>tbody>tr>td>input")).get(6).sendKeys(Postcode);
            this.driver.findElements(By.cssSelector(".content>form>table>tbody>tr>td>input")).get(7).sendKeys(City);


            new Actions(this.driver)
                    .moveToElement( this.driver.findElement(By.cssSelector(".select2-selection__arrow")))
                    .click().sendKeys("United States").sendKeys(Keys.ENTER)
                   .perform();



            this.driver.findElements(By.cssSelector(".content>form>table>tbody>tr>td>input")).get(9).sendKeys(Email);
            this.driver.findElements(By.cssSelector(".content>form>table>tbody>tr>td>input")).get(10).sendKeys(Phone);
            this.driver.findElements(By.cssSelector(".content>form>table>tbody>tr>td>input")).get(11).sendKeys(Password);
            this.driver.findElements(By.cssSelector(".content>form>table>tbody>tr>td>input")).get(12).sendKeys(Password);
            this.driver.findElements(By.cssSelector(".content>form>table>tbody>tr>td>button")).get(0).click();
            this.driver.findElement(By.xpath(".//*[@id='box-account']/div/ul/li[4]/a")).click();
            this.driver.findElements(By.cssSelector(".content>form>table>tbody>tr>td>input")).get(0).sendKeys(Email);
            this.driver.findElements(By.cssSelector(".content>form>table>tbody>tr>td>input")).get(1).sendKeys(Password);
            this.driver.findElement(By.cssSelector(".button-set>button")).click();
        }

    }
    @After
    public void stop()
    {
        this.driver.quit();
        this.driver = null;
    }
}
