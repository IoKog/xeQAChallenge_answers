package gr.xe.selenium.qaChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
//Re-build the broken test
public class part_3 {

    WebDriver driver;
    WebDriverWait wait;

    String username = "kogchylakis-qachallenge@yopmail.com";
    String password = "123456789";

    @BeforeClass
    public void initialize(){
        //Set the web driver binary path to the corresponding property
        String path = System.getProperty("user.dir");
        String chromeDriverPath = path + "/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    }

    @Test(priority = 0, description = "Visit gr.xe.gr, select land for sale from the categories and perform a search")
    public void visitXeSelectLandForSaleFromCategoriesPerformSearch() {
        //We start the chromedriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //We define the implicit wait for this driver
        wait = new WebDriverWait(driver, 25);
        //We visit xe.gr
        driver.navigate().to("https://www.xe.gr/");
        //Select land for sale
        driver.findElement(By.xpath("//a[@href='https://www.xe.gr/property/s/poliseis-gis-oikopedon']")).click();
        //Perform the search
        driver.findElement(By.cssSelector("input.button-property")).click();
    }

    @Test(priority = 1, description = "Expand the filters and apply plot")
    public void expandFiltersApplyPlot() {
        //The cookies banner obstructs our test here so we have to close it
        closeCookiesBannerIfPresent();
        //Expand the filters tab
        driver.findElement(By.cssSelector("button.filters-button")).click();
        //Select the plot option
        driver.findElement(By.id("building-type-option-plot-checkbox-input_label")).click();
        //Apply the filter
        driver.findElement(By.cssSelector("button.submit-button")).click();
    }

    @Test(priority = 2, description = "Save the previous search")
    public void saveSearch() {
        //Click to save the search
        driver.findElement(By.cssSelector("[data-testid='save-search-btn']")).click();
        driver.findElement(By.cssSelector("a.button-property")).click();
        //Wait for username to be visible and fill it in
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
        driver.findElement(By.cssSelector("input#email")).sendKeys(username);
        //Fill in password
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        //Click to connect
        driver.findElement(By.cssSelector("a.button")).click();
        //Hint: If your search is already saved you are redirected to your saved searches instead of being able to save your search.
        //Manually delete your search if you already saved it once and  want to save it again.
        //Wait some seconds for loading after sign in
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Click to save the search again
        driver.findElement(By.cssSelector("[data-testid='save-search-btn']")).click();
        //Deal with the save search pop-up
        saveSearchDoNothingIfAlreadySaved();
    }

    @AfterClass
    public void close(){
        //We close the driver
        driver.quit();
    }

    /*
     * Closes the cookies banner if it's present on the page
     */
    public void closeCookiesBannerIfPresent(){
        if(driver.findElements(By.cssSelector(".btn-disclaimer-ok")).size()>0)
            driver.findElement(By.cssSelector(".btn-disclaimer-ok")).click();
    }

    /*
     * Clicks to save search in the save search pop up and then closes it.
     * If no pop-up is present then it does nothing.
     */
    public void saveSearchDoNothingIfAlreadySaved(){
        if(driver.findElements(By.cssSelector("input.button-property")).size()>0) {
            //Save the search
            driver.findElement(By.cssSelector("input.button-property")).click();
            //Close the success modal
            driver.findElement(By.cssSelector(".xe-modal-close .xe.xe-close")).click();
        }
    }
}
