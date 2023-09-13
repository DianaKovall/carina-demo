package koval.mobile.myfitnesspal.gui.android.modal;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansTaskManagerPageBase;
import koval.mobile.myfitnesspal.gui.common.modal.DatePickerModalBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = DatePickerModalBase.class)
public class DatePickerModal extends DatePickerModalBase {

    @FindBy(id = "com.myfitnesspal.android:id/btnDate")
    private ExtendedWebElement datePickerButton;


    @FindBy(xpath = "//*[@resource-id='com.myfitnesspal.android:id/month_grid']//*[@text='%s']")
    private ExtendedWebElement dayByText;


    @FindBy(id = "com.myfitnesspal.android:id/confirm_button")
    private ExtendedWebElement okButton;
    public DatePickerModal(WebDriver driver) {
        super(driver);
    }

    public DatePickerModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    @Override
    public PlansTaskManagerPageBase setDay(int day) {
        datePickerButton.click();
        dayByText.format(day).click();
        okButton.click();
        return initPage(getDriver(), PlansTaskManagerPageBase.class);

    }

}
