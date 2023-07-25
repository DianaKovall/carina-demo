package koval.video.web.gatling.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id ="username")
    ExtendedWebElement userNameField;

    @FindBy(id ="password")
    ExtendedWebElement passwordField;

    @FindBy(xpath ="/html/body/div[1]/div/div[3]/form/button[text()=\"Login\"]")
    ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(){
        userNameField.type(R.TESTDATA.get("gatling_username"));
        passwordField.type(R.TESTDATA.get("gatling_password"));
        loginButton.click();
        return new HomePage(driver);
    }

}
