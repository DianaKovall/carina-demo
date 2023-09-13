package koval.video.mobile.tabletkiua.gui.common;

import koval.video.mobile.tabletkiua.services.enums.MyAbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MainPageBase extends MyAbstractPage {


    public MainPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract LoginPageBase clickOnLoginNotification();

    public abstract ProfilePageBase clickOnProfileIcon();
}
