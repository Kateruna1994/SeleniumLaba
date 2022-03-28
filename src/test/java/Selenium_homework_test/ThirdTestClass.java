package Selenium_homework_test;

import Utils.Utils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ThirdTestClass extends BaseTest {

    @Test
    public void checkDynamicClickAndDoubleClick() {
        String exceptionMessageAppearsAfterClickButtonClickMe = "You have done a dynamic click";
        String exceptionMessageAppearsAfterClickButtonRightClickMe = "You have done a right click";
        String exceptionMessageAppearsAfterClickButtonDoubleClickMe = "You have done a double click";

        WebElement trackButton = driver.findElement
                (By.xpath("//div[@class='card-body']/h5[text()='Elements']"));
        Utils.scrollToElement(driver, trackButton);
        trackButton.click();

        WebElement clickOnTheButton = driver.findElement(By.xpath("//span[text()='Buttons']"));
        Utils.scrollToElement(driver, clickOnTheButton);
        clickOnTheButton.click();

        WebElement clickOnClickMeButton = driver.findElement
                (By.xpath("//div[@class='mt-4']/button[text()='Click Me']"));
        clickOnClickMeButton.click();

        WebElement afterClickButtonClickMe = driver.findElement(By.id("dynamicClickMessage"));
        String actualResultAfterClickButtonClickMe = afterClickButtonClickMe.getText();

        Assertions.assertThat(actualResultAfterClickButtonClickMe)
                .as("After click button must be message appears" + exceptionMessageAppearsAfterClickButtonClickMe)
                .isEqualTo(exceptionMessageAppearsAfterClickButtonClickMe);

        WebElement clickOnButtonRightClickMe = driver.findElement
                (By.xpath("//div[@class='mt-4']/button[@id='rightClickBtn']"));
        Actions actions = new Actions(driver);
        actions.contextClick(clickOnButtonRightClickMe).build().perform();

        WebElement afterRightClickingOnTheButtonRightClickMe = driver.findElement
                (By.id("rightClickMessage"));
        String actualResultAfterClickOnTheButton = afterRightClickingOnTheButtonRightClickMe.getText();

        Assertions.assertThat(actualResultAfterClickOnTheButton)
                .as("After click button must be message appears" + exceptionMessageAppearsAfterClickButtonRightClickMe)
                .isEqualTo(exceptionMessageAppearsAfterClickButtonRightClickMe);

        WebElement doubleClickButtonDoubleClickMe = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickButtonDoubleClickMe).build().perform();

        WebElement afterRightClickingOnTheButtonDoubleClickMe = driver.findElement
                (By.id("doubleClickMessage"));
        String actualResultAfterClickOnTheButtonDoubleClickMe =
                afterRightClickingOnTheButtonDoubleClickMe.getText();

        Assertions.assertThat(actualResultAfterClickOnTheButtonDoubleClickMe)
                .as("After click button must be message appears" +
                        exceptionMessageAppearsAfterClickButtonDoubleClickMe)
                .isEqualTo(exceptionMessageAppearsAfterClickButtonDoubleClickMe);
    }

}

