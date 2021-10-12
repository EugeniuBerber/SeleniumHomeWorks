package HomeWorks.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task {
    public static String url = "https://www.aa.com/homePage.do";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement departingCal = driver.findElement(By.xpath("//input[@id=\"aa-leavingOn\"]//following::button[1]"));
        departingCal.click();
        //departing date
        WebElement dMonth = driver.findElement(By.xpath("(//div[@class=\"ui-datepicker-title\"])[1]//descendant::span[1]"));
        String dMonthText = dMonth.getText();
        while (!dMonthText.equals("April")) {
            WebElement nextBtn = driver.findElement(By.xpath("//a[@data-handler= 'next']"));
            nextBtn.click();
            dMonthText = driver.findElement(By.xpath("(//div[@class=\"ui-datepicker-title\"])[1]//descendant::span[1]")).getText();
        }

        List<WebElement> departDates = driver.findElements(By.xpath("(//table[@class=\"ui-datepicker-calendar\"])[1]/tbody/tr/td"));
        for (WebElement depDate : departDates) {
            if (depDate.getText().equals("19")) {
                depDate.click();
                break;
            }
        }
        //returning date
        WebElement returningCal = driver.findElement(By.xpath("//input[@id=\"aa-leavingOn\"]//following::button[2]"));
        returningCal.click();

        WebElement rMonth = driver.findElement(By.xpath("(//div[@class=\"ui-datepicker-title\"])[2]//descendant::span[1]"));
        String rMonthText = rMonth.getText();
        while (!rMonthText.equals("July")) {
            WebElement nextBtn = driver.findElement(By.xpath("//a[@aria-label=\"Next Month\"]"));
            nextBtn.click();
            rMonthText = driver.findElement(By.xpath("(//div[@class=\"ui-datepicker-title\"])[1]//descendant::span[1]")).getText();
        }
        List<WebElement> returnDates = driver.findElements(By.xpath("(//table[@class=\"ui-datepicker-calendar\"])[1]/tbody/tr/td"));
        for (WebElement retDate : returnDates) {
            if (retDate.getText().equals("25")) {
                retDate.click();
                break;
            }
        }
        Thread.sleep(1000);
        //destination selection
        WebElement airportSearchBtn = driver.findElement(By.xpath("(//a[@class=\"widget aaAirportLookup\"])[2]"));
        airportSearchBtn.click();
        //country-state search
        WebElement countriesDD = driver.findElement(By.id("countryCode"));
        Select selectC  = new Select(countriesDD);
        selectC.selectByValue("US");
        Thread.sleep(2000);
        WebElement statesDD = driver.findElement(By.id("stateCode"));
        Select selectS  = new Select(statesDD);
        selectS.selectByVisibleText("New York");
        Thread.sleep(1000);
        WebElement airport = driver.findElement(By.xpath("//span[@class=\"airport-code\" and text()='LGA']"));
        airport.click();
        //search flights
        Thread.sleep(1000);
        WebElement searchBtn = driver.findElement(By.id("flightSearchForm.button.reSubmit"));
        searchBtn.click();


        Thread.sleep(2000);
        driver.quit();
    }
}
