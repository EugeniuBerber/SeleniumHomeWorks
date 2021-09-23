package HomeWorks.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class task3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.ebay.com/");

        WebElement allCategories = driver.findElement(By.xpath("//select[@id='gh-cat']"));
        Select ebayAllCategories = new Select(allCategories);
        List<WebElement> optionsList = ebayAllCategories.getOptions();
        for (WebElement obj : optionsList) {
            System.out.println(obj.getText());
        }
        ebayAllCategories.selectByVisibleText("Computers/Tablets & Networking");
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
        WebElement headerText = driver.findElement(By.xpath("//h1[@class=\"b-pageheader\"]//child::span"));
        if (headerText.isDisplayed())
            System.out.println("-----------Header text is displayed-----------");
        else
            System.out.println("Failed");
        Thread.sleep(2000);
        driver.quit();


    }
}