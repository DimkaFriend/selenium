package Modul_5.HomeWork9;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.Select;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * Created by boltenkov on 17.03.2017.
 */
public class TestGoogleChrome {
    private WebDriver driver;


    @Before
    public void start()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("unexpectedAlertBehaviour","ignore");
        this.driver= new ChromeDriver(caps);
    }

    @Test
    public void myFirst()
    {
        this.driver.get("http://localhost:81/lifecart/admin/");
        this.driver.findElement(By.name("username")).clear();
        this.driver.findElement(By.name("username")).sendKeys("admin");
        this.driver.findElement(By.name("password")).clear();
        this.driver.findElement(By.name("password")).sendKeys("admin");
        this.driver.findElement(By.name("login")).click();


    }

    @Test
    public void sortedCountries()
    {
        this.driver.get("http://localhost:81/lifecart/admin/");
        this.driver.findElement(By.name("username")).clear();
        this.driver.findElement(By.name("username")).sendKeys("admin");
        this.driver.findElement(By.name("password")).clear();
        this.driver.findElement(By.name("password")).sendKeys("admin");
        this.driver.findElement(By.name("login")).click();
        this.driver.get("http://localhost:81/lifecart/admin/?app=countries&doc=countries");

        List<WebElement> NameTd = this.driver.findElements(By.xpath(".//td[5]"));
        List<String> listNameNextIt = new LinkedList<>();
        String[] set = new String[NameTd.size()];
        for(int i = 0 ; i < NameTd.size(); i ++)
        {
            set[i] =NameTd.get(i).getAttribute("textContent").toString();
        }
        Arrays.parallelSort(set);


        for(int i = 0; i < set.length; i ++)
        {
            String s = NameTd.get(i).getAttribute("textContent").toString();
            if(!set[i].equals(s))
            {
                System.out.println("не отсортирован");
            }

            if(Integer.parseInt(this.driver.findElement(By.xpath(".//tr["+(i+2)+"]/td["+((Integer.parseInt(NameTd.get(i).getAttribute("cellIndex")))+2)+"]")).getText())!=0)
            {
                listNameNextIt.add(this.driver.findElement(By.xpath(".//tr["+(i+2)+"]/td["+((Integer.parseInt(NameTd.get(i).getAttribute("cellIndex")))+1)+"]")).getText().toString());
            }
        }

        ListIterator<String> it = listNameNextIt.listIterator();
        while(it.hasNext())
        {

            this.driver.findElement(By.linkText(it.next())).click();

            WebElement[] el = this.driver.findElements((By.xpath(".//*[@id='table-zones']//tr/td[3]"))).toArray(new WebElement[0]);
            set=new String[el.length];
            for(int i = 0 ; i < el.length; i ++)
            {
                set[i] =el[i].getAttribute("textContent").toString();
            }
            Arrays.parallelSort(set);
            this.driver.navigate().back();
        }

    }


    @Test
    public void sortedGeoZona()
    {
        this.driver.get("http://localhost:81/lifecart/admin/");
        this.driver.findElement(By.name("username")).clear();
        this.driver.findElement(By.name("username")).sendKeys("admin");
        this.driver.findElement(By.name("password")).clear();
        this.driver.findElement(By.name("password")).sendKeys("admin");
        this.driver.findElement(By.name("login")).click();
        this.driver.get("http://localhost:81/lifecart/admin/?app=geo_zones&doc=geo_zones");
        int el = this.driver.findElements(By.cssSelector("tr.row>td>a:not([title='Edit'])")).toArray(new WebElement[0]).length;
        String[] s ;
        for(int i = 0; i < el ; i ++)
        {
            this.driver.findElements(By.cssSelector("tr.row>td>a:not([title='Edit'])")).get(i).click();
            WebElement[] elNext = this.driver.findElements(By.xpath(".//form//tr[not(selected='selected')]/td[3]/select")).toArray(new WebElement[0]);
            s = new String[elNext.length];
            for(int j = 0; j < elNext.length; j++)
            {
                Select select = new Select(elNext[j]);
                s[j]=select.getFirstSelectedOption().getText().toString();
            }
            Arrays.sort(s);
            for(int j = 0; j < elNext.length; j++)
            {
                Select select = new Select(elNext[j]);
                if(!s[j].equals(select.getFirstSelectedOption().getText().toString()))
                {
                    System.out.println("не отсортирован");
                }
            }

            this.driver.navigate().back();
        }


    }
    @After
    public void stop()
    {
        this.driver.quit();
        this.driver = null;
    }
}
