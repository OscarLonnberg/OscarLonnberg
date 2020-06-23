import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class WareHouseUpdateSalesCompany {

    ChromeDriver driver;
    //Open website
    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ",C:\\Users\\46720\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://vardenisiffror.se/");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public void ExternalChange() {
        //Warehouse
        driver.findElement(By.id("ctl00_contentPlaceHolderAdmin_ProfileParameters1_linkButtonActiveWarehousesExternal")).click();
        WebDriverWait wait = new WebDriverWait(driver,20, 5);
        WebElement parentDiv = driver.findElement(By.id("divWarehousesData"));
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentDiv, By.tagName("td")));
        //Thread.sleep(5000);
        driver.findElement(By.id("ctl00_contentPlaceHolderAdmin_ProfileParameters1_buttonOkWarehousesDialog")).click();
        //DC
        driver.findElement(By.id("ctl00_contentPlaceHolderAdmin_ProfileParameters1_linkButtonActiveDCsExternal")).click();
        parentDiv = driver.findElement(By.id("divDCsData"));
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentDiv, By.tagName("td")));
        driver.findElement(By.id("ctl00_contentPlaceHolderAdmin_ProfileParameters1_buttonOkDCsDialog")).click();
    }
   //after each test put in a 5second sleep if needed (Not needed in STG/UAT
    public void InternalChange() {
        //Warehouse
        driver.findElement(By.id("ctl00_contentPlaceHolderAdmin_ProfileParameters1_linkButtonActiveWarehousesInternal")).click();
        WebDriverWait wait = new WebDriverWait(driver,20, 5);
        WebElement parentDiv = driver.findElement(By.id("divWarehousesData"));
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentDiv, By.tagName("td")));
        driver.findElement(By.id("ctl00_contentPlaceHolderAdmin_ProfileParameters1_buttonOkWarehousesDialog")).click();
        //DC
        parentDiv = driver.findElement(By.id("divDCsData"));
        driver.findElement(By.id("ctl00_contentPlaceHolderAdmin_ProfileParameters1_linkButtonActiveDCsInternal")).click();
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentDiv, By.tagName("td")));
        driver.findElement(By.id("ctl00_contentPlaceHolderAdmin_ProfileParameters1_buttonOkDCsDialog")).click();

    }

    public void SaveChanges()  {
        driver.findElement(By.id("ctl00_contentPlaceHolderAdmin_buttonSave2")).click();
    }
    @Test
    public void allUsers()  {
        PageObject pageObject = new PageObject();
        List<Row> allUsers =  pageObject.getAllUsers();
        DataFormatter dataFormatter = new DataFormatter();

        for (Row row: allUsers) {
            try {
                String cellValue = dataFormatter.formatCellValue(row.getCell(0));
                driver.navigate().to(cellValue);
                ExternalChange();
                InternalChange();
                SaveChanges();
            } catch (InvalidArgumentException e){
                System.out.println("FEL");
                System.out.println(row.getRowNum());
            }

        }

    }
}

