package koval.video.web.gatling.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends AbstractPage {


    @FindBy(xpath = "/html/body/nav/div/ul[2]/li/a")
    ExtendedWebElement loginButton;

    public WelcomePage(WebDriver driver) {
        super(driver);
        setPageURL("http://demostore.gatling.io/");
    }

    public LoginPage clickOnLoginButton(){
        loginButton.click();
        return new LoginPage(driver);
    }

}
