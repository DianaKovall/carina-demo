package koval.video.web.wish.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"main_navigation_menu\"]/div/div[2]/div[1]")
    ExtendedWebElement signInButton;


    @FindBy(id = "pop-div0942454712903529")
    ExtendedWebElement cookiesFrame;


    public WelcomePage(WebDriver driver) {
        super(driver);
        setPageURL("https://www.wish.com/");
    }


    public WelcomePage acceptCookies() {
        CookiesPage cookiesPage = new CookiesPage(driver);
        driver.switchTo().frame(cookiesFrame.getElement());
        cookiesPage.acceptCookies();
        getDriver().switchTo().defaultContent();
        return new WelcomePage(driver);
    }

    public SignInPage clickOnSignInButton() {
        signInButton.click(20);
        return new SignInPage(driver);
    }



}
