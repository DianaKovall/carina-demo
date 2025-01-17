package koval.mobile.myfitnesspal.gui.ios.downMenuPages.dashboardPage;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.DashboardPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.dashboardPage.mePage.MePageBase;
import koval.mobile.myfitnesspal.gui.common.loginPages.SignUpPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DashboardPageBase.class)
public class DashboardPage extends DashboardPageBase {


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(int timeout) {
        throw new NotImplementedException();
    }

    @Override
    public MePageBase openMePage() {
        throw new NotImplementedException();
    }


    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {
        throw new NotImplementedException();
    }

    @Override
    public SearchFoodPageBase clickSearchForFoodContainer() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isUserPremium() {
        throw new NotImplementedException();
    }

    @Override
    public SignUpPageBase lastMealPopUpSkip() {
        throw new NotImplementedException();
    }


}
