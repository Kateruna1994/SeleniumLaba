package Selenium_homework_test;

import Utils.Utils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SeventhTestClass extends BaseTest {

    @Test
    public void checkTextExistInFirstBigSquare() {
        String expectedResult = "This is a sample page";

        WebElement adArrow = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("close-fixedban")));
        adArrow.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("close-fixedban")));

        WebElement trackButton = driver.findElement
                (By.xpath("//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']"));
        Utils.scrollToElement(driver, trackButton);
        trackButton.click();

        WebElement clickButton = driver.findElement
                (By.xpath("//li[@class='btn btn-light ']/span[text()='Frames']"));
        Utils.scrollToElement(driver, clickButton);
        clickButton.click();

        driver.switchTo().frame("frame1");
        WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
        String actualResultCheckThatText = sampleHeading.getText();

        Assertions.assertThat(actualResultCheckThatText)
                .as("There is text" + " " + expectedResult)
                .isEqualTo(expectedResult);
    }


}
