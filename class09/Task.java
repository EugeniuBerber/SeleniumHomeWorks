package HomeWorks.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task {
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement userPwd = driver.findElement(By.cssSelector("input#txtPassword"));
        userPwd.sendKeys("Hum@nhrm123");
        WebElement loginBtn = driver.findElement(By.xpath("//input[contains(@value, 'LOGIN')]"));
        loginBtn.submit();
        WebElement leaveBtn = driver.findElement(By.xpath("//*[text()=\"Leave\"]"));
        leaveBtn.click();
        WebElement leaveListBtn = driver.findElement(By.linkText("Leave List"));
        leaveListBtn.click();
        WebElement calendarFrom = driver.findElement(By.id("calFromDate"));
        calendarFrom.click();



        WebElement monthDD = driver.findElement(By.className("ui-datepicker-month"));
        Select selectM =new Select(monthDD);
        selectM.selectByVisibleText("Apr");

        WebElement yearDD = driver.findElement(By.className("ui-datepicker-year"));
        Select selectY = new Select(yearDD);
        selectY.selectByVisibleText("2022");

        List<WebElement> fromDates = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]/tbody/tr/td"));
        for (WebElement x : fromDates
             ) {
           if (x.getText().equals("29")){
               x.click();
               break;
           }
        }
        Thread.sleep(500);
        //===========================================================================//
        WebElement calendarTo= driver.findElement(By.id("calToDate"));
        calendarTo.click();
        WebElement monthDD2 = driver.findElement(By.xpath("//select[@class=\"ui-datepicker-month\" and contains(@onchange, \"DP_jQuery\")]"));
        Select selectM2 = new Select(monthDD2);
        selectM2.selectByVisibleText("May");

        WebElement yearDD2 = driver.findElement(By.className("ui-datepicker-year"));
        Select selectY2 = new Select(yearDD2);
        selectY2.selectByVisibleText("2025");

        List<WebElement> toDates = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]/tbody/tr/td"));
        for (WebElement x : toDates
        ) {
            if (x.getText().equals("12")){
                x.click();
                break;
            }
        }
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[@id=\"leaveList_chkSearchFilter_checkboxgroup\"]//following-sibling::input"));
        for (WebElement x : checkBoxes) {
            String val = x.getAttribute("value");
            if (val.contains("-1")||val.contains("0")||val.contains("1")){
                x.click();
            }
        }
        WebElement subUnit = driver.findElement(By.id("leaveList_cmbSubunit"));
        Select select1 = new Select(subUnit);
        select1.selectByVisibleText("IT Support");
        WebElement searchBtn = driver.findElement(By.id("btnSearch"));
        searchBtn.click();
        Thread.sleep(1000);
        driver.quit();
    }
}
