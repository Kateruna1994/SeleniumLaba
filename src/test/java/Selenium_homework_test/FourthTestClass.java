package Selenium_homework_test;

import Utils.Utils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class FourthTestClass extends BaseTest {

    @Test
    public void checkIfNewTabIsOpen() {
        String expectedResult = "This is a sample page";

        WebElement trackButton = driver.findElement
                (By.xpath("//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']"));
        Utils.scrollToElement(driver, trackButton);
        trackButton.click();

        WebElement clickButtonBrowserWindows = driver.findElement
                (By.xpath("//li[@id='item-0']/span[text()='Browser Windows']"));
        Utils.scrollToElement(driver, clickButtonBrowserWindows);
        clickButtonBrowserWindows.click();

        WebElement clickButtonNewTab = driver.findElement(By.id("tabButton"));
        clickButtonNewTab.click();

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));

        WebElement checkWhetherTheTextIsCorrect = driver.findElement
                (By.xpath("//h1[text()='This is a sample page']"));
        String actualResultAfterGoingToNewPageWeSeeText = checkWhetherTheTextIsCorrect.getText();

        Assertions.assertThat(actualResultAfterGoingToNewPageWeSeeText)
                .as("Text must be " + expectedResult)
                .isEqualTo(expectedResult);


    }
}

