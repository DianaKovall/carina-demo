package koval.video.mobile.gsmarena.gui.common.buttomMenuPages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.video.mobile.gsmarena.service.enums.ButtomMenuItems;
import koval.video.mobile.gsmarena.service.enums.MyGSMArenaMenuItems;
import org.openqa.selenium.WebDriver;

public abstract class NewsPageBase extends AbstractPage{


    public NewsPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract AbstractPage openPageFromBurgerMenu(MyGSMArenaMenuItems myGSMArenaMenuItems);

    public abstract AbstractPage openPageFromButtomMenu(ButtomMenuItems buttomMenuItems);

}
