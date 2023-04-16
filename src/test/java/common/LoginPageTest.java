package common;

import base.BaseTest;
import constants.messages.AssertionMessages;
import constants.urls.URLs;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void testFailedLogin(){
        String errorMessageDisplayStatus = loginPage.wrongCredentialsDisplayStatus();
        Assert.assertEquals(errorMessageDisplayStatus, AssertionMessages.LOGIN_ERROR_MESSAGE_EXPECTED_STATUS);
    }

    @Test
    public void testSuccessfulLogin(){
        loginPage.successfulLogIn();
        Assert.assertEquals(driver.getCurrentUrl(), URLs.HOME_URL);
    }
}
