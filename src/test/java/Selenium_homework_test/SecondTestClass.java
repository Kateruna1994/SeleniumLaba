package Selenium_homework_test;

import Utils.Utils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SecondTestClass extends BaseTest {

    @Test
    public void checkIfAnInscriptionAppears() {
        String expectedResult = "You have selected :wordFile";

        WebElement trackButton = driver.findElement
                (By.xpath("//div[@class='card-body']/h5[text()='Elements']"));
        Utils.scrollToElement(driver, trackButton);
        trackButton.click();

        WebElement clickButtonCheckBox = driver.findElement(By.xpath("//span[text()='Check Box']"));
        Utils.scrollToElement(driver, clickButtonCheckBox);
        clickButtonCheckBox.click();

        WebElement uncollapseHomeButton = driver.findElement(By.xpath("//span[@class='rct-text']/button"));
        uncollapseHomeButton.click();

        WebElement uncollapseDownloadsButton = driver.findElement
                (By.xpath("//label[@for='tree-node-downloads']/preceding-sibling::button"));
        uncollapseDownloadsButton.click();

        WebElement findTheNameWordFile_doc = driver.findElement(By.xpath("//span[text()='Word File.doc']"));
        findTheNameWordFile_doc.getText();

        WebElement clickOnCheckBoxWordFile_doc = driver.findElement
                (By.xpath("//label[@for='tree-node-wordFile']/span[@class='rct-checkbox']"));
        clickOnCheckBoxWordFile_doc.click();

        WebElement checkIfTheInscriptionAppears = driver.findElement(By.id("result"));
        String actualResultCheckTheAppearanceOfTheInscription = checkIfTheInscriptionAppears.getText();

        Assertions.assertThat(actualResultCheckTheAppearanceOfTheInscription)
                .as("After implementation the inscription should appear" + expectedResult)
                .isEqualTo(actualResultCheckTheAppearanceOfTheInscription);
    }
        }
