package gr.xe.selenium.qaChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class part_1 {

    /*
     * first part of the challenge
     * */
    @Test(priority = 0, description = "Visit gr.xe.gr and click on the property tab and click the first item from the list of results")
    public void visitXeClickPropertyTab() {
        String path = System.getProperty("user.dir");
        String chromeDriverPath = path + "/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.xe.gr/");
        driver.findElement(By.cssSelector("#property-tab")).click();
        driver.findElement(By.cssSelector("input.button-property")).click();
        //click the first random item from the result list
        driver.findElement(By.className("slick-list")).click();
        driver.quit();
    }
}
