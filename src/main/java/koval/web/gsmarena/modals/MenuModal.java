package koval.web.gsmarena.modals;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import koval.web.gsmarena.pages.MerchHomePage;
import koval.web.gsmarena.pages.SearchResultsPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MenuModal extends AbstractUIObject {

    @FindBy(id = "login-active")
    ExtendedWebElement loginButton;

    @FindBy(id = "login-active")
    ExtendedWebElement profileButton;

    @FindBy(xpath = "//*[@class=\"article-info\"]//div/h1[text()=' %s - user account']")
    ExtendedWebElement userAccountText;

    @FindBy(id = "topsearch")
    ExtendedWebElement searchBar;

    @FindBy(id = "topsearch-text")
    ExtendedWebElement activeSearchBar;

    @FindBy(xpath = "//*[@id=\"topsearch\"]/div[2]/a[1]")
    ExtendedWebElement searchButton;

    @FindBy(xpath = "//*[@id=\"social-connect\"]/a[6]")
    ExtendedWebElement merchButton;

    public MenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public LoginModal clickOnLoginButton() {
        loginButton.click(10);
        return new LoginModal(driver);
    }

    public boolean isUserLogged(String userName) {
        profileButton.click();
        return userAccountText.format(userName).isElementPresent();
    }


    public SearchResultsPage searchForItem(String itemName) {
        searchBar.click();
        activeSearchBar.type(itemName);
        searchButton.click();
        return new SearchResultsPage(driver);
    }

    public MerchHomePage clickOnMerchButton(){
        merchButton.click();
        return new MerchHomePage(driver);
    }

}
