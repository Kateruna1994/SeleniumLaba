package Selenium_homework_test;

import Utils.Utils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SixTestClass extends BaseTest {

    @Test
    public void checkThatAlertDisappear() {
        String expectedResult = "This alert appeared after 5 seconds";

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


        WebElement clickButtonClickMe = driver.findElement(By.id("timerAlertButton"));
        clickButtonClickMe.click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String actualAlertLabel = alert.getText();

        alert.accept();

        Assertions.assertThat(actualAlertLabel)
                .as("Text notification is open" + " " + expectedResult)
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

