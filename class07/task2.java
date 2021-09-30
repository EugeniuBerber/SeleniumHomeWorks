package HomeWorks.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class task2 {
    public static String url = "http://www.uitestpractice.com/Students/Contact";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement link = driver.findElement(By.xpath("//a[contains(text(),'This is a Ajax link')]"));
        link.click();
        WebElement textBox = driver.findElement(By.xpath("//div[@class='ContactUs']"));
        String text = textBox.getText();
        System.out.println(text);

        driver.quit();
    }
}

