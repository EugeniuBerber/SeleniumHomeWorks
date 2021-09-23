package HomeWorks.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class task1 {
    static String url = "https://www.facebook.com/";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(2000);

        WebElement monthDD = driver.findElement(By.xpath("//select[@id='month']"));
        Select months = new Select(monthDD);
        if (months.getOptions().size() == 12)
            System.out.println("Month dropdown Menu has 12 moths option : Passed");
        else
            System.out.println("Month dropdown Menu has 12 moths option: Failed");

        WebElement daysDD = driver.findElement(By.xpath("//select[@id='day']"));
        Select days = new Select(daysDD);
        if (days.getOptions().size() == 31)
            System.out.println("Day dropdown Menu has 31 days option: Passed");
        else
            System.out.println("Day dropdown Menu has 31 days option: Failed");

        WebElement yearDD = driver.findElement(By.xpath("//select[@id='year']"));
        Select years = new Select(yearDD);
        if (years.getOptions().size() == 115)
            System.out.println("Year dropdown Menu has 115 years option: Passed");
        else
            System.out.println("Year dropdown Menu has 115 years option: Failed");

        months.selectByVisibleText("Apr");
        Thread.sleep(500);
        days.selectByValue("29");
        Thread.sleep(500);
        years.selectByValue("1990");
        Thread.sleep(500);

        driver.quit();

    }

}
/*
    List<WebElement> mothList = months.getOptions();
        for (WebElement element: mothList
                ) {
                System.out.println(element.getText());
                }*/
