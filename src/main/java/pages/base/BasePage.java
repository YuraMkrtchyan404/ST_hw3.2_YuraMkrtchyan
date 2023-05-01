package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.common.LoginPage;

import java.time.Duration;
import constants.locators.BasePageLocators;
public class BasePage {
    protected WebDriver driver;
    private By iconHomePage = By.xpath(BasePageLocators.ICON_RELATIVE_CSS_SELECTOR);
    private By signOutButton = By.linkText(BasePageLocators.SIGN_OUT_LINK_TEXT);

    public LoginPage clickSignOut(){
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(signOutButton));
        button.click();
        return new LoginPage(driver);
    }
}
