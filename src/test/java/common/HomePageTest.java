package common;

import base.BaseTest;
import constants.messages.AssertionMessages;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void testSignOut(){
        HomePage homePage = loginPage.successfulLogIn();
        homePage.signOut();
        Assert.assertTrue(driver.getCurrentUrl().contains(AssertionMessages.EXPECTED_PART_IN_LOGIN_URL));
    }

    @Test
    public void testListSize(){
        HomePage homePage = loginPage.successfulLogIn();
        int actualListSize = homePage.linkListSize();
        Assert.assertEquals(actualListSize, AssertionMessages.EXPECTED_LIST_SIZE);
    }
}
