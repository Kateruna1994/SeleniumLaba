package Selenium_homework_test;

import Utils.Utils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class EleventhTestClass extends BaseTest {

    @Test
    public void checkIfWhiteIsSelected() {
        String expectedResult = "White";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement adArrow = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("close-fixedban")));
        adArrow.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("close-fixedban")));

        WebElement clickButton = driver.findElement
                (By.xpath("//div[@class='card-body']/h5[text()='Widgets']"));
        Utils.scrollToElement(driver, clickButton);
        clickButton.click();

        WebElement clickSelectMenu = driver.findElement
                (By.xpath("//li[@class='btn btn-light ']/span[text()='Select Menu']"));
        Utils.scrollToElement(driver, clickSelectMenu);
        clickSelectMenu.click();


        WebElement selectWebElement = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(selectWebElement);
        select.selectByVisibleText("White");

        String actualResultWasSelected = select.getFirstSelectedOption().getText();

        Assertions.assertThat(actualResultWasSelected)
                .as("Must be was selected " + expectedResult)
                .isEqualTo(expectedResult);

    }
}
