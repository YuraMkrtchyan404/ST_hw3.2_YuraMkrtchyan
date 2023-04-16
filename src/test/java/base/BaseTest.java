package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import constants.urls.URLs;
import pages.common.LoginPage;

public class BaseTest {

    public static final String WEBDRIVER = "webdriver.chrome.driver";
    public static final String DRIVER_PATH = "src/drivers/chromedriver.exe";
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        System.setProperty(WEBDRIVER,DRIVER_PATH);
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        moveToLoginPage();
    }

    @BeforeMethod
    public void moveToLoginPage(){
        driver.get(URLs.LOGIN_URL);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("src/screenshots/" +  result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}