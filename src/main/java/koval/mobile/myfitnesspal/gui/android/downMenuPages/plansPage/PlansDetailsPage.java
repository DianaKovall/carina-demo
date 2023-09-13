package koval.mobile.myfitnesspal.gui.android.downMenuPages.plansPage;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansDetailsPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansTaskManagerPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PlansDetailsPageBase.class)
public class PlansDetailsPage extends PlansDetailsPageBase {

    @FindBy(id = "com.myfitnesspal.android.plans:id/btnStartPlan")
    private ExtendedWebElement startPlanButton;

    @FindBy(id = "com.myfitnesspal.android:id/positiveBtn")
    private ExtendedWebElement continueAlertButton;

    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/message' and @text='%s']")
    private ExtendedWebElement alertMessage;

    @FindBy(xpath = "//android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView[@text='%s']")
    private ExtendedWebElement pageNameByText;


    public PlansDetailsPage(WebDriver driver) {
        super(driver);
    }



    @Override
    public boolean isPageOpened(String pageName, String titleText) {
        return pageNameByText.format(pageName).isElementPresent(TIMEOUT_TWENTY) &&
                itemByText.format(titleText).isElementPresent(TIMEOUT_TWENTY);
    }


    @Override
    public PlansDetailsPageBase clickOnStartPlan() {
        startPlanButton.click(TIMEOUT_FIFTEEN);
        return initPage(getDriver(), PlansDetailsPageBase.class);
    }

    @Override
    public PlansTaskManagerPageBase clickOnContinueAlertMessageIfPresent() {
        continueAlertButton.clickIfPresent(TIMEOUT_TEN);
        return initPage(getDriver(), PlansTaskManagerPageBase.class);
    }

    @Override
    public boolean isAlertMessageAboutEndingPlanOpen() {
        return alertMessage.format(ENDING_PLAN_MESSAGE).isElementPresent(TIMEOUT_TEN);
    }


}
