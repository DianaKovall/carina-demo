package koval.mobile.myfitnesspal.gui.common.modal;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.myfitnesspal.gui.MyAbstractPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansTaskManagerPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;


public abstract class DatePickerModalBase extends MyAbstractPageBase {

    public DatePickerModalBase(WebDriver driver) {
        super(driver);
    }

    public DatePickerModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public abstract PlansTaskManagerPageBase setDay(int day);
}
