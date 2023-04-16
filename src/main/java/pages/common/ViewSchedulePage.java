package pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;
import constants.locators.ViewSchedulePageLocators;

import java.time.Duration;

public class ViewSchedulePage extends BasePage {

    private By printButton = By.xpath(ViewSchedulePageLocators.PRINT_BUTTON_XPATH);
    private By switchToWeekView = By.xpath(ViewSchedulePageLocators.SWITCH_TO_WEEK_VIEW_RELATIVE_XPATH);
    private By switchToBasicView = By.xpath(ViewSchedulePageLocators.SWITCH_TO_BASIC_VIEW_RELATIVE_XPATH);
    public ViewSchedulePage(WebDriver driver) {
        this.driver = driver;
    }

    public String printButtonName() {
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(printButton));
        return button.getText();
    }

    public String clickViewSwitch(){
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(switchToWeekView));
        button.click();
        WebElement button1 = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(switchToBasicView));
        return button1.getText();
    }
}
