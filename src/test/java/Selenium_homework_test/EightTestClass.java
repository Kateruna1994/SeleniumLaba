package Selenium_homework_test;

import Utils.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class EightTestClass {
    private WebDriver driver;

    @BeforeMethod
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
    }

    @Test
    public void checkForAppearsAndDisappearsNewModalAppears() {
        String expectedResultButton = "Small Modal";
        String expectedResultText = "This is a small modal. It has very less content";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement adArrow = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("close-fixedban")));
        adArrow.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("close-fixedban")));

        WebElement trackButton = driver.findElement
                (By.xpath("//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']"));
        Utils.scrollToElement(driver, trackButton);
        trackButton.click();

        WebElement clickButton = driver.findElement
                (By.xpath("//li[@class='btn btn-light ']/span[text()='Modal Dialogs']"));
        Utils.scrollToElement(driver, clickButton);
        clickButton.click();

        WebElement clickButtonSmallModal = driver.findElement(By.xpath("//button[text()='Small modal']"));
        Utils.scrollToElement(driver, clickButtonSmallModal);
        clickButtonSmallModal.click();

        SoftAssertions softAssertions = new SoftAssertions();


        WebElement findRequiredText = driver.findElement(By.xpath("//div[text()='Small Modal']"));
        String actualResultCheckIfThereIsText = findRequiredText.getText();

        softAssertions.assertThat(actualResultCheckIfThereIsText)
                .as("Сheck if there is text with the inscription" + expectedResultButton)
                .isEqualTo(expectedResultButton);

        WebElement findTheText = driver.findElement
                (By.xpath("//div[text()='This is a small modal. It has very less content']"));
        String actualResultCheckIfThereIsTheNecessaryText = findTheText.getText();

        softAssertions.assertThat(actualResultCheckIfThereIsTheNecessaryText)
                .as("Check if there is text" + expectedResultText)
                .isEqualTo(expectedResultText);

        WebElement clickButtonClose = driver.findElement(By.id("closeSmallModal"));
        clickButtonClose.click();

        boolean isModalPresent = wait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.id("example-modal-sizes-title-sm")));

        softAssertions.assertThat(isModalPresent)
                .as("The modal window must be closed")
                .isTrue();

        softAssertions.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
    }
}
