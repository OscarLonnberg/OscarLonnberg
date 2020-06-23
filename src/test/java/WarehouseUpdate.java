import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class WarehouseUpdate {

    ChromeDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\46720\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://vardenisiffror.se/unitlists");
        driver.manage().window().maximize();

    }
    @Test
    public void ExternalWareHouseChange() throws InterruptedException {
        //Warehouse
        driver.findElement(By.id("ctl00_contentPlaceHolderAdmin_ProfileParameters1_linkButtonActiveWarehousesExternal")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("ctl00_contentPlaceHolderAdmin_ProfileParameters1_buttonOkWarehousesDialog")).click();
        //DC
        driver.findElement(By.id("ctl00_contentPlaceHolderAdmin_ProfileParameters1_linkButtonActiveDCsExternal")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("ctl00_contentPlaceHolderAdmin_ProfileParameters1_buttonOkDCsDialog")).click();

        Thread.sleep(1000);
        wait(250);

    }
}


