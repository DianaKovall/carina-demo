package koval.video.mobile.gsmarena.gui.common.buttomMenuPages;


import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.video.mobile.gsmarena.gui.common.SearchResultsPageBase;
import koval.video.mobile.gsmarena.service.enums.MyGSMArenaMenuItems;
import koval.video.mobile.gsmarena.service.enums.PhoneTabs;
import org.openqa.selenium.WebDriver;


public abstract class PhonesPageBase extends AbstractPage {


    public PhonesPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract PhonesPageBase enterSearchKeyword(String searchKeyword);

    public abstract SearchResultsPageBase clickOnGoButton();

    public abstract AbstractPage openPageFromBurgerMenu(MyGSMArenaMenuItems myGSMArenaMenuItems);

    public abstract AbstractPage openTabByContext(PhoneTabs phoneTabs);
}
