package pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import constants.locators.LoginPageLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id(LoginPageLocators.USER_NAME_FIELD_ID);
    private By passwordField = By.id(LoginPageLocators.PASSWORD_FIELD_ID);
    private By loginButton = By.id(LoginPageLocators.LOGIN_BUTTON_ID);
    private By wrongCredentialsErrorMessage = By.id(LoginPageLocators.WRONG_CREDENTIALS_ERROR_MESSAGE_ID);

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsernameField(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public HomePage clickLoginButton (){
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        button.click();
        return new HomePage(driver);
    }

    public HomePage successfulLogIn(){
        setUsernameField(LoginPageLocators.LOGIN);
        setPasswordField(LoginPageLocators.PASSWORD);
        return clickLoginButton();
    }

    public String wrongCredentialsDisplayStatus(){
        setUsernameField(LoginPageLocators.WRONG_LOGIN);
        setPasswordField(LoginPageLocators.WRONG_PASSWORD);
        clickLoginButton();
        return driver.findElement(wrongCredentialsErrorMessage).getCssValue("display");
    }
}
