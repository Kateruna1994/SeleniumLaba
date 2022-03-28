package Selenium_homework_test;

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FourteenthTestClass extends BaseTest {

    @Test
    public void checkColorNameFieldAndDate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement adArrow = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("close-fixedban")));
        adArrow.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("close-fixedban")));

        WebElement clickButton = driver.findElement(By.xpath("//div[@class='card-body']/h5[text()='Forms']"));
        Utils.scrollToElement(driver, clickButton);
        clickButton.click();

        WebElement clickOnTheField = driver.findElement
                (By.xpath("//div[@class='element-list collapse show']"));
        wait.until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//div[@class='element-list collapse show']")));
        clickOnTheField.click();


//        WebElement clickSubmitButton = driver.findElement(By.id("submit"));
//        clickSubmitButton.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
//        Utils.scrollToElement(driver, clickSubmitButton);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
//        clickSubmitButton.click();
        //кінець не доробила
    }
}
