package HomeWorks.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task2 {
    static String url = "https://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);

        WebElement firstAlert = driver.findElement(By.xpath("//button[@onclick=\"myAlertFunction()\"]"));
        firstAlert.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(1000);

        WebElement secondAlert = driver.findElement(By.xpath("//button[@onclick=\"myConfirmFunction()\"]"));
        secondAlert.click();
        driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(1000);

        WebElement thirdAlert = driver.findElement(By.xpath("//button[text()=\"Click for Prompt Box\"]"));
        thirdAlert.click();
        driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys(" Hohohoho");
        alert.accept();
        Thread.sleep(2000);

        driver.quit();



    }
}