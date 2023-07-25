package koval.video.web.gsmarena.pages.menu;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends AbstractPage {


    @FindBy(xpath = "//*[@id=\"body\"]/div/div[2]/h3[text()=\"Favorite devices\"]/following-sibling::ul/li/a/strong/span[text()[1]='%s' and text()[2]='%s']")
    ExtendedWebElement favoriteDevice;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public boolean isDeviceAddedToFavorite(String deviceName, String deviceModel){
        return favoriteDevice.format(deviceName, deviceModel).isElementPresent(20);
    }


}
