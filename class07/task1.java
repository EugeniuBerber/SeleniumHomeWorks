package HomeWorks.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class task1 {
    public static String url = "https://demoqa.com/browser-windows";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        WebElement newTab = driver.findElement(By.id("tabButton"));
        WebElement newWindow = driver.findElement(By.xpath("//button[@class=\"mt-4 btn btn-primary\"]"));
        WebElement newWindowMessage = driver.findElement(By.id("messageWindowButton"));
        List<WebElement> windows = new ArrayList<>();
        windows.add(newTab);
        windows.add(newWindow);
        windows.add(newWindowMessage);

        for (WebElement obj : windows) {
            System.out.println(obj.getText());
            obj.click();
        }
        Set<String> allWindowHandle = driver.getWindowHandles();
        System.out.println(allWindowHandle.size());
        for (String x : allWindowHandle) {
            System.out.println(x);
        }
        System.out.println("======================================================");
        Iterator<String> iterator = allWindowHandle.iterator();
        String mainP = iterator.next();
        String newTabHandle = iterator.next();
        driver.switchTo().window(newTabHandle);
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        String newWindowHandle = iterator.next();
        driver.switchTo().window(newWindowHandle);
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        String newWindowMessageHandle = iterator.next();
        driver.switchTo().window(newWindowMessageHandle);
        System.out.println(driver.findElement(By.xpath("//body[contains(text(),'Knowledge')]")).getText());

    }
}
