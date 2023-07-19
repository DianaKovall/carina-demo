package koval.video.web.gsmarena.modals;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.zebrunner.carina.utils.R;
import koval.video.web.gsmarena.pages.ForgottenPasswordPage;
import koval.video.web.gsmarena.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginModal extends AbstractUIObject {

    @FindBy(id = "email")
    ExtendedWebElement emailField;

    @FindBy(id = "upass")
    ExtendedWebElement passwordField;


    @FindBy(xpath = "//*[@id=\"login-popup2\"]/a")
    ExtendedWebElement forgotPasswordLink;

    @FindBy(id = "nick-submit")
    ExtendedWebElement loginButton;

    public LoginModal(WebDriver driver) {
        super(driver);
    }

    public HomePage login() {
        emailField.type(R.TESTDATA.get("gsmarena_mail"));
        passwordField.type(R.TESTDATA.get("gsmarena_password"));
        loginButton.click();
        return new HomePage(driver);
    }

    public ForgottenPasswordPage clickOnForgotPasswordLink(){
        forgotPasswordLink.click();
        return new ForgottenPasswordPage(driver);
    }

}
