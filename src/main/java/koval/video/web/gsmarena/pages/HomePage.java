package koval.video.web.gsmarena.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.video.web.gsmarena.modals.MenuModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"header\"]/div/div")
    MenuModal menuModal;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLogged(String userName) {
        return menuModal.isUserLogged(userName);
    }

    public SearchResultsPage searchForItem(String itemName) {
        return menuModal.searchForItem(itemName);
    }

    public MerchHomePage clickOnMerchButton(){
        return menuModal.clickOnMerchButton();
    }

}
