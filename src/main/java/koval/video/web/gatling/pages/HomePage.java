package koval.video.web.gatling.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "/html/body/nav/div[1]/form/span[text()='Hi, %s']")
    ExtendedWebElement welcomeText;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLogged(){
        return welcomeText.format(R.TESTDATA.get("gatling_username")).isElementPresent(20);
    }

}
