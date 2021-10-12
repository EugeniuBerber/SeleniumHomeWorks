package HomeWorks.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class task1 {
    public static String url = "https://the-internet.herokuapp.com/dynamic_controls";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement checkBox = driver.findElement(By.xpath("//div[@id=\"checkbox\"]/descendant::input"));
        checkBox.click();
        WebElement removeBtn = driver.findElement(By.xpath("//button[@onclick=\"swapCheckbox()\"]"));
        removeBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        WebElement checkBoxMessage = driver.findElement(By.id("message"));
        if (checkBoxMessage.isDisplayed()) {
            System.out.println("The message is displayed as: " + checkBoxMessage.getText());
        }
        WebElement enableBtn = driver.findElement(By.xpath("//button[@onclick = 'swapInput()' and text() = 'Enable']"));
        enableBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id=\"input-example\"]//descendant::input")));
        WebElement textBox = driver.findElement(By.xpath("//form[@id=\"input-example\"]//descendant::input"));
        if (textBox.isEnabled()) {
            System.out.println("Text box is Enabled");
        } else
            System.out.println("Text box is Disabled");
        textBox.sendKeys("It doesn't work....");

        WebElement disableBtn = driver.findElement(By.xpath("//button[@onclick=\"swapInput()\"]"));
        disableBtn.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(textBox)));
        if (textBox.isEnabled()) {
            System.out.println("Text box is Enabled");
        } else
            System.out.println("Text box is Disabled");
    }
}
