package HomeWorks.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class task1 {
    // verify syntax logo on left displayed , verify enroll today is enabled
    static String url = "https://syntaxprojects.com/bootstrap-iframe.php";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);

        WebElement headerText = driver.findElement(By.xpath("//span[@class=\"gum\"]"));
        if (headerText.getText().equalsIgnoreCase("AUTOMATION TESTING PLATFORM BY SYNTAX"))
            System.out.println("Text in header is displayed");
        else
            System.out.println("Text in header is not displayed");

        driver.switchTo().frame("FrameTwo");
        WebElement enrollBtn = driver.findElement(By.xpath("//div[@class=\"text-block-2\" and text()='Enroll today']"));
        if (enrollBtn.isEnabled())
            System.out.println("Enroll button is enabled");
        else
            System.out.println("Enroll button is not enabled");
        driver.switchTo().defaultContent();

        driver.switchTo().frame("FrameOne");
        WebElement syntaxLogo = driver.findElement(By.xpath("//img[@alt=\"Syntax Technologies Logo\"]"));
        if (syntaxLogo.isDisplayed()) {
            System.out.println("Logo is displayed");
        } else
            System.out.println("Error");
        driver.quit();
    }
}
