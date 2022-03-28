package Selenium_homework_test;

import Utils.Utils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ThirteenTestClass extends BaseTest {
    @Test
    public void checkDynamicProperties() {
        String expectedResultBlu = "#007bff";
        String expectedResultWhite = "#f8f9fa";


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement adArrow = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("close-fixedban")));
        adArrow.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("close-fixedban")));

        WebElement clickButton = driver.findElement
                (By.xpath("//div[@class='card-body']/h5[text()='Interactions']"));
        Utils.scrollToElement(driver, clickButton);
        clickButton.click();

        WebElement clickSelectableButton = driver.findElement
                (By.xpath("//li[@id='item-1']/span[text()='Selectable']"));
        Utils.scrollToElement(driver, clickSelectableButton);
        clickSelectableButton.click();

        WebElement selectCrasJustoOdio = driver.findElement(By.xpath("//li[text()='Cras justo odio']"));
        selectCrasJustoOdio.click();

        WebElement selectMorbiLeoRisus = driver.findElement(By.xpath("//li[text()='Morbi leo risus']"));
        selectMorbiLeoRisus.click();

        String first = selectCrasJustoOdio.getCssValue("background-color");
        String actualResultCrasJustoOdio = Color.fromString(first).asHex();

        Assertions.assertThat(actualResultCrasJustoOdio)
                .as("Color must be " + expectedResultBlu)
                .isEqualTo(expectedResultBlu);

        String second = selectMorbiLeoRisus.getCssValue("background-color");
        String actualResultMorbiLeoRisus = Color.fromString(second).asHex();

        Assertions.assertThat(actualResultMorbiLeoRisus).
                as("Color must be " + expectedResultBlu)
                .isEqualTo(actualResultMorbiLeoRisus);

        WebElement selectDapibusAcFacilisis = driver.findElement
                (By.xpath("//li[text()='Dapibus ac facilisis in']"));
        String third = selectDapibusAcFacilisis.getCssValue("background-color");
        String actualResultDapibusAcFacilisis = Color.fromString(third).asHex();

        Assertions.assertThat(actualResultDapibusAcFacilisis)
                .as("An unselected item is highlighted in white")
                .isEqualTo(expectedResultWhite);
// запуталась незнала як доробити
    }
}
