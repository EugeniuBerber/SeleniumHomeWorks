package HomeWorks.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class task2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.facebook.com/");
        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("TEST");
        driver.findElement(By.name("lastname")).sendKeys("TEST");
        driver.findElement(By.name("reg_email__")).sendKeys("test@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("test1234");
        Thread.sleep(1000);

        WebElement monthDD = driver.findElement(By.xpath("//select[@id='month']"));
        Select months = new Select(monthDD);
        months.selectByVisibleText("Apr");
        Thread.sleep(500);
        WebElement daysDD = driver.findElement(By.xpath("//select[@id='day']"));
        Select days = new Select(daysDD);
        days.selectByVisibleText("11");
        Thread.sleep(500);
        WebElement yearDD = driver.findElement(By.xpath("//select[@id='year']"));
        Select years = new Select(yearDD);
        years.selectByVisibleText("1956");
        Thread.sleep(1000);

        //WebElement genderBox = driver.findElement(By.xpath("//label[contains(text(), 'Female')]//ancestor::span"));
        List<WebElement> gender = driver.findElements(By.xpath("//input[@name='sex']"));
        Thread.sleep(1000);
        for (WebElement obj:gender) {
            if (obj.getAttribute("value").equals("2"))
                obj.click();
        }
        WebElement signUp = driver.findElement(By.xpath("//button[@name='websubmit']"));
        signUp.click();
        Thread.sleep(2000);
        driver.quit();

    }
}
