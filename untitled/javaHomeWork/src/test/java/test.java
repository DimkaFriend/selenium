import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        this.driver.get("http://www.google.com/");

    }

    @After
    public void stop()
    {
        this.driver.quit();;
        this.driver = null;
    }
}
