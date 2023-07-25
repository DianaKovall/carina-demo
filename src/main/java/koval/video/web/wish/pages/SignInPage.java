package koval.video.web.wish.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {


    @FindBy(xpath = "//*[@id=\"react-app\"]/div/div[8]/div[2]/div/div/div[3]/div[1]/div[1]/form/div[2]")
    ExtendedWebElement test;

    @FindBy(xpath = "//*[@id=\"react-app\"]/div/div[8]/div[2]/div/div/div[3]/div[1]/div[1]/form/div[3]/div")
    ExtendedWebElement test2;
   @FindBy(xpath = "//*[@id=\"react-app\"]/div/div[8]/div[2]/div/div/div[3]/div[1]/div[1]/form/div[2]/div/input")
    ExtendedWebElement emailField;

    @FindBy(xpath = "//*[@id=\"react-app\"]/div/div[8]/div[2]/div/div/div[3]/div[1]/div[1]/form/div[3]/div/input")
    ExtendedWebElement passwordField;

    public SignInPage(WebDriver driver) {
        super(driver);
        setPageURL("https://www.wish.com/");
    }

    public SignInPage enterValidCredentials(){
        test.click();
        emailField.type(R.TESTDATA.get("wish_mail"));
        passwordField.type(R.TESTDATA.get("wish_password"));
        return new SignInPage(driver);
    }

}
