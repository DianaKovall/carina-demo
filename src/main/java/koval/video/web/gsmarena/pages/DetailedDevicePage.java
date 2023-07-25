package koval.video.web.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.video.web.gsmarena.modals.MenuModal;
import koval.video.web.gsmarena.pages.menu.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DetailedDevicePage extends AbstractPage {


    @FindBy(xpath = "//*[@id=\"body\"]/div[1]/div[1]/div/div[2]/ul/li[3]/a/strong/i")
    ExtendedWebElement becomeFanButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div")
    MenuModal menuModal;


    @FindBy(xpath = "//*[@id='body']/div[1]/div[1]/div/div[2]/ul/li[3]/a/span[text()='%s']")
    ExtendedWebElement stateOfFanLabel;
    public DetailedDevicePage(WebDriver driver) {
        super(driver);
    }

    public DetailedDevicePage clickOnBecomeFanButton(){
        if(stateOfFanLabel.format("Become a fan").isElementPresent(10))
        {
            becomeFanButton.click(20);
        }

        return new DetailedDevicePage(driver);
    }


    public ProfilePage clickOnProfileButton(){
        return menuModal.clickOnProfileButton();
    }


}
