package koval.video.web.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ForgottenPasswordPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"udata-f\"]/input")
    ExtendedWebElement emailField;

    @FindBy(xpath = "//*[@id=\"ucsubmit-f\"]//input")
    ExtendedWebElement submitButton;

    @FindBy(xpath = "//*[@id=\"body\"]/div/div[2]/h3")
    ExtendedWebElement resetConfirmMessage;

    public ForgottenPasswordPage(WebDriver driver) {
        super(driver);
    }

    public ForgottenPasswordPage submitEmail() {

        emailField.type(R.TESTDATA.get("gsmarena_mail"));
        submitButton.click();
        return new ForgottenPasswordPage(driver);
    }


    public boolean isResetMessagePresent() {
       return resetConfirmMessage.isElementPresent() &&
               resetConfirmMessage.getText().equals("The link to reset your password was sent to your email.");
    }


}
