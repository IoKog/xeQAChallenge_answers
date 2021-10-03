package gr.xe.selenium.qaChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class part_2 {
    /*
     * second part of the challenge
     * */
    @Test(priority = 0, description = "Visit gr.xe.gr and click on the jobs tab and apply filter")
    public void visitXeClickJobsTab() {
        String path = System.getProperty("user.dir");
        String chromeDriverPath = path + "/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.xe.gr/");
        driver.findElement(By.cssSelector("#property-tab")).click();
        driver.findElement(By.cssSelector("input.button-property")).click();
        driver.findElement(By.className("open-range-filter-btn")).click();
        //set minimum price
        driver.findElement(By.xpath("//input[@data-testid='minimum_price_input']")).sendKeys("500000");
        //click filter again to apply it
        driver.findElement(By.className("open-range-filter-btn")).click();
        driver.quit();
    }
}
