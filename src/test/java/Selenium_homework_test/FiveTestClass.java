package Selenium_homework_test;

import Utils.Utils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FiveTestClass extends BaseTest {

    @Test
    public void checkThatTextNotificationsAreOpenAndClosed() {
        String expectedResult = "You clicked a button";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement adArrow = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("close-fixedban")));
        adArrow.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("close-fixedban")));

        WebElement trackButton = driver.findElement
                (By.xpath("//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']"));
        Utils.scrollToElement(driver, trackButton);
        trackButton.click();

        WebElement clickButton = driver.findElement(By.xpath("//li[@id='item-1']/span[text()='Alerts']"));
        Utils.scrollToElement(driver, clickButton);
        clickButton.click();


        WebElement clickButtonClickMe = driver.findElement
                (By.xpath("//div[@class='col']/button[@id='alertButton']"));
        clickButtonClickMe.click();

        Alert alert = driver.switchTo().alert();
        String actualAlertLabel = alert.getText();

        alert.accept();

        Assertions.assertThat(actualAlertLabel)
                .as("After pressing the button we check whether the notification with the text has opened" +
                        expectedResult)
                .isEqualTo(expectedResult);

        boolean isAlertStillPresent;
        try {
            driver.switchTo().alert();
            isAlertStillPresent = true;
        } catch (NoAlertPresentException e) {
            isAlertStillPresent = false;
        }

        Assertions.assertThat(isAlertStillPresent)
                .as("After pressing the button we check whether the alert is closed")
                .isEqualTo(false);

    }

}

