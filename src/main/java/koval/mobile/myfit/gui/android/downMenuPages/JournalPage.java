package koval.mobile.myfit.gui.android.downMenuPages;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfit.gui.android.modal.DownMenuModal;
import koval.mobile.myfit.gui.android.modal.PlusButtonModal;
import koval.mobile.myfit.gui.common.downMenuPages.JournalPageBase;
import koval.mobile.myfit.gui.common.modal.PlusButtonModalBase;
import koval.mobile.myfit.gui.android.modal.ManageAccountModal;
import koval.mobile.myfit.gui.common.ActivityPageBase;
import koval.mobile.myfit.service.enums.DownMenuElement;
import koval.mobile.myfit.service.enums.PlusButtonMenuElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = JournalPageBase.class)
public class JournalPage extends JournalPageBase {


    @FindBy(id = "com.google.android.apps.fitness:id/og_apd_internal_image_view")
    private ManageAccountModal accountImageModal;

    @FindBy(id = "com.google.android.apps.fitness:id/bottom_navigation")
    private DownMenuModal downMenuModal;

    @FindBy(id = "om.google.android.apps.fitness:id/add_entry_fab")
    private PlusButtonModal plusButtonModal;

    @FindBy(id = "com.google.android.apps.fitness:id/collapsing_toolbar")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[contains(@resource-id, 'journal_recycler_view')]/child::*[@class='android.view.ViewGroup']")
    private List<ExtendedWebElement> activityList;

    @FindBy(id = "com.google.android.apps.fitness:id/session_start_time")
    private List<ExtendedWebElement> startTimeList;

    @FindBy(id = "com.google.android.apps.fitness:id/session_duration")
    private List<ExtendedWebElement> durationList;

    @FindBy(id = "com.google.android.apps.fitness:id/session_title")
    private List<ExtendedWebElement> titleList;

    @FindBy(id = "com.google.android.apps.fitness:id/session_title")
    private ExtendedWebElement activityTitleElement;


    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public JournalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {

        return title.isElementPresent(TIMEOUT_FIVE) && title.getAttribute("content-desc").equals("Journal");
    }


    @Override
    public int getAccountImageColor() throws IOException {

        return accountImageModal.getAccountImageColor();
    }


    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {

        return downMenuModal.openPageByName(downMenuElement);
    }

    @Override
    public String getActivityName() {

        if (activityList.isEmpty()) {
            Assert.fail("[ JOURNAL PAGE ] List of Activities is empty!");
        }

        return titleList.get(0).getText();
    }


    @Override
    public Calendar getStartTime() throws ParseException {

        if (startTimeList.isEmpty()) {
            Assert.fail("[ JOURNAL PAGE ] Start Time list is empty!");
        }

        String startTime = startTimeList.get(0).getText();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(START_TIME_FORMAT);
        cal.setTime(sdf.parse(startTime));

        return cal;
    }

    @Override
    public Calendar getDuration() throws ParseException {

        if (durationList.isEmpty()) {
            Assert.fail("[ JOURNAL PAGE ] Duration list is empty!");
        }

        String duration = durationList.get(0).getText();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DURATION_FORMAT);
        cal.setTime(sdf.parse(duration));

        return cal;
    }


    @Override
    public boolean isActivityPresent(String activityTitle) {


        waitUntil(ExpectedConditions.visibilityOfElementLocated(activityTitleElement.getBy()), TIMEOUT_FIFTEEN);

        LOGGER.info(String.valueOf(activityTitleElement.getText()));
        LOGGER.info(String.valueOf(titleList.size()));

        if (titleList.isEmpty()) {
            Assert.fail("[ JOURNAL PAGE ] List of titles is empty!");
        }

        return titleList.get(0).getText().contains(activityTitle);
    }

    @Override
    public ActivityPageBase openActivityByIndex(int activityIndex) {

        if (!activityList.isEmpty()) {

            titleList.get(activityIndex).click();
        }

        return initPage(getDriver(), ActivityPageBase.class);
    }

    @Override
    public ActivityPageBase openActivity() {
        return openActivityByIndex(0);
    }

    @Override
    public int getActivityListSize() {

        return activityList.size();
    }

    @Override
    public PlusButtonModalBase openPlusButtonMenu() {

        return plusButtonModal.openPlusButtonMenu();
    }

    @Override
    public AbstractPage openPageFromPlusButtonMenuByName(PlusButtonMenuElement plusButtonMenuElement) {
        return plusButtonModal.openPageByName(plusButtonMenuElement);
    }

    @Override
    public JournalPageBase clearActivityList() {

        while (getActivityListSize() != 0) {

            String firstActivityName = getActivityName();

            ActivityPageBase activityPageBase = openActivity();

            if (!activityPageBase.isPageOpened(firstActivityName)) {
                Assert.fail(String.format("[ ACTIVITY PAGE ] Activity page  '%s' is not opened!", firstActivityName));
            }

            activityPageBase.deleteActivity();
        }

        return initPage(getDriver(), JournalPageBase.class);

    }
}
