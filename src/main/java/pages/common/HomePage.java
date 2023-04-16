package pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;
import constants.locators.HomePageLocators;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {
    private By viewSchedule = By.xpath(HomePageLocators.VIEW_SCHEDULE_RELATIVE_XPATH);
    private By linkList = By.xpath(HomePageLocators.LINK_LIST_RELATIVE_XPATH);
    private By signOut = By.linkText(HomePageLocators.SIGN_OUT_LINK_TEXT);
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public ViewSchedulePage clickViewSchedule(){
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(viewSchedule));
        button.click();
        return new ViewSchedulePage(driver);
    }

    public int linkListSize(){
        WebElement list = driver.findElement(linkList);
        List<WebElement> listElements = list.findElements(By.tagName("li"));
        return listElements.size();
    }

    public LoginPage signOut(){
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(signOut));
        button.click();
        return new LoginPage(driver);
    }
}
