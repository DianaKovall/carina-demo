package koval.video.mobile.tabletkiua.gui.common;

import koval.video.mobile.tabletkiua.services.enums.MyAbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends MyAbstractPage {


    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase enterValidCredentials();

    public abstract MainPageBase clickOnLogin();
}
