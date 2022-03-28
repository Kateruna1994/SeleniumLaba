package Selenium_homework_test;

import Utils.Utils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FifteenthTestClass extends BaseTest {

    @Test
    public void checkColorsAppears() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement adArrow = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("close-fixedban")));
        adArrow.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("close-fixedban")));

        WebElement clickButton = driver.findElement
                (By.xpath("//div[@class='card-body']/h5[text()='Widgets']"));
        Utils.scrollToElement(driver, clickButton);
        clickButton.click();

        WebElement trackButton = driver.findElement
                (By.xpath("//li[@id='item-1']/span[text()='Auto Complete']"));
        Utils.scrollToElement(driver, trackButton);
        trackButton.click();

        WebElement clickOnTheField = driver.findElement(By.id("autoCompleteMultipleContainer"));
        clickOnTheField.click();
        Actions actions = new Actions(driver);
        actions.sendKeys("o").build().perform();

        List<WebElement> options = driver.findElements
                (By.xpath("//div[contains(@class,'auto-complete__option')]"));

        List<String> actualColors = new ArrayList<>();
        for (int i = 0; i < options.size(); i++) {
            String color = options.get(i).getText();
            actualColors.add(color);

        }
        Assertions.assertThat(actualColors)
                .as("Expected to be Yellow, Voilet, Indigo")
                .containsExactly("Yellow", "Voilet", "Indigo");

//        WebElement hhh = driver.findElement
//                (By.id("//div[@id='react-select-2-option-1']"));
//        hhh.click();

    }
}
