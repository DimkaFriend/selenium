import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by boltenkov on 15.03.2017.
 */
public class test {
    private WebDriver driver;


    @Before
    public void start()
    {
        this.driver= new ChromeDriver();
    }

    @Test
    public void myFirst()
    {
        this.driver.get("http://admin:admin@localhost:81/lifecart/admin/");// почему то всплавал alert для basic авторизации, эту  строчку наверное можно считать  костылем.
        this.driver.findElement(By.name("username")).clear();
        this.driver.findElement(By.name("username")).sendKeys("admin");
        this.driver.findElement(By.name("password")).clear();
        this.driver.findElement(By.name("password")).sendKeys("admin");
        this.driver.findElement(By.name("login")).click();
        new WebDriverWait(this.driver, 10).until(ExpectedConditions.titleIs("My Store"));
        this.driver.findElement(By.linkText("Appearence")).click();

    }

    @After
    public void stop()
    {
        this.driver.quit();
        this.driver = null;
    }
}
