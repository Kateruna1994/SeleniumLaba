package Selenium_homework_test;

import Utils.Utils;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class TenTestClass extends BaseTest {

    @Test
    public void checkTabActivity() {
        WebElement adArrow = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("close-fixedban")));
        adArrow.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("close-fixedban")));

        WebElement clickButton = driver.findElement
                (By.xpath("//div[@class='card-body']/h5[text()='Widgets']"));
        Utils.scrollToElement(driver, clickButton);
        clickButton.click();

        WebElement clickTabsButton = driver.findElement
                (By.xpath("//li[@class='btn btn-light ']/span[text()='Tabs']"));
        Utils.scrollToElement(driver, clickTabsButton);
        clickTabsButton.click();

        SoftAssertions softAssertions = new SoftAssertions();

        WebElement clickOnTheTabWhat = driver.findElement(By.id("demo-tab-what"));
        clickOnTheTabWhat.click();
        boolean actualResultClickTabsWhat = clickOnTheTabWhat.isEnabled();

        softAssertions.assertThat(actualResultClickTabsWhat)
                .as("Can click on taboos What")
                .isTrue();

        WebElement clickOnTheTabsOrigin = driver.findElement(By.id("demo-tab-origin"));
        clickOnTheTabsOrigin.click();
        boolean actualResultClickTabsOrigin = clickOnTheTabsOrigin.isEnabled();

        softAssertions.assertThat(actualResultClickTabsOrigin)
                .as("Can click on taboos Origin")
                .isTrue();

        WebElement clickOnTheTabsUse = driver.findElement(By.id("demo-tab-use"));
        clickOnTheTabsUse.click();
        boolean actualResultClickTabsUse = clickOnTheTabsUse.isEnabled();

        softAssertions.assertThat(actualResultClickTabsUse)
                .as("Can click on taboos Use")
                .isTrue();

        WebElement clickOnTheTabsMore = driver.findElement(By.id("demo-tab-more"));
        //clickOnTheTabsMore.click();
        boolean actualResultClickTabsMore = clickOnTheTabsMore.isEnabled();

        softAssertions.assertThat(actualResultClickTabsMore)
                .as("Can click on taboos More")
                .isTrue();

        softAssertions.assertAll();
    }

}
