package Selenium_homework_test;

import Utils.Utils;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class NineTestClass extends BaseTest {
    @Test
    public void checkTheFullnessOfTheIndicator() {
        String expectedResultAfterClickStartButton = "100%";
        String expectedResultAfterClickResetButton = "0%";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement adArrow = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("close-fixedban")));
        adArrow.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("close-fixedban")));

        WebElement clickButton = driver.findElement
                (By.xpath("//div[@class='card-body']/h5[text()='Widgets']"));
        Utils.scrollToElement(driver, clickButton);
        clickButton.click();

        WebElement clickButtonProgressBar = driver.findElement
                (By.xpath("//li[@class='btn btn-light ']/span[text()='Progress Bar']"));
        Utils.scrollToElement(driver, clickButtonProgressBar);
        clickButtonProgressBar.click();

        SoftAssertions softAssertions = new SoftAssertions();

        WebElement clickStart = driver.findElement(By.id("startStopButton"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("startStopButton")));
        clickStart.click();

        WebElement element = driver.findElement(By.id("progressBar"));
        wait.until(ExpectedConditions.textToBePresentInElement(element, "100%"));
        String actualResult = element.getText();

        softAssertions.assertThat(actualResult)
                .as("Must be " + expectedResultAfterClickStartButton)
                .isEqualTo(expectedResultAfterClickStartButton);

        WebElement clickResetButton = driver.findElement(By.id("resetButton"));
        clickResetButton.click();

        wait.until(ExpectedConditions.textToBePresentInElement(element, "0%"));
        String actualResultAfter = element.getText();

        softAssertions.assertThat(actualResultAfter)
                .as("Must be" + expectedResultAfterClickResetButton)
                .isEqualTo(expectedResultAfterClickResetButton);

        softAssertions.assertAll();
    }
}
