package koval.mobile.myfitnesspal.gui.android.downMenuPages.plansPage;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.android.modal.DatePickerModal;
import koval.mobile.myfitnesspal.gui.android.modal.DownMenuModal;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansDetailsPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansHubPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansTaskManagerPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.workout.LogWorkoutPageBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.ArrayList;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PlansTaskManagerPageBase.class)
public class PlansTaskManagerPage extends PlansTaskManagerPageBase {


    @FindBy(id = "com.myfitnesspal.android.plans:id/hubRecyclerView")
    private ExtendedWebElement plansContainer;

    @FindBy(id = "com.myfitnesspal.android.plans:id/planSurveyTitle")
    private ExtendedWebElement surveyTitle;

    @FindBy(id = "com.myfitnesspal.android.plans:id/what_do_you_think")
    private ExtendedWebElement whatDoYouThinkTitle;

    @FindBy(id = "com.myfitnesspal.android.plans:id/take_the_survey")
    private ExtendedWebElement takeTheSurveyTitle;


    @FindBy(id = "com.myfitnesspal.android.plans:id/action_show_plans_hub")
    private ExtendedWebElement addPlansPlusButton;

    @FindBy(id = "com.myfitnesspal.android.plans:id/welcomeActionBtn")
    private ExtendedWebElement welcomeActionButton;


    @FindBy(id = "com.myfitnesspal.android.plans:id/planTitle")
    private ExtendedWebElement planTitle;

    @FindBy(id = "com.myfitnesspal.android:id/btnDate")
    private ExtendedWebElement dateLabel;

    @FindBy(id = "com.myfitnesspal.android:id/bottomNavigationBar")
    private DownMenuModal downMenuModal;

    @FindBy(id = "com.myfitnesspal.android.plans:id/task_day_more_menu")
    private ExtendedWebElement moreMenu;

    @FindBy(id = "com.myfitnesspal.android.plans:id/logWorkout")
    private ExtendedWebElement logWorkoutButton;


    @FindBy(id = "com.myfitnesspal.android:id/snackbar_action")
    private ExtendedWebElement viewButton;


    @FindBy(id = "com.myfitnesspal.android:id/snackbar_text")
    private ExtendedWebElement workoutLoggedMessage;


    @FindBy(id = "com.myfitnesspal.android:id/btnNext")
    private ExtendedWebElement nextButton;

    @FindBy(id = "com.myfitnesspal.android:id/btnDate")
    private DatePickerModal datePicker;


    @FindBy(xpath = "//*[@resource-id=\"com.myfitnesspal.android.plans:id/taskTitle\"][@text='%s']")
    private ExtendedWebElement taskTitleByText;

    public PlansTaskManagerPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened(int timeout) {
        return dateLabel.isElementPresent(timeout);
    }

    @Override
    public String getCurrentPlanTitle() {
        return planTitle.getText();
    }

    @Override
    public AbstractPage openPageFromDownMenuByName(DownMenuElement downMenuElement) {

        return downMenuModal.openPageByName(downMenuElement);
    }

    @Override
    public PlansTaskManagerPageBase clickOnNextButton() {
        nextButton.click();
        return initPage(getDriver(), PlansTaskManagerPageBase.class);
    }


    @Override
    public JSONArray getPlansArrayFromJSON(String path) {

        JSONArray planArray = null;
        try {
            JSONObject obj = new JSONObject(fileToString(path));

            planArray = obj.getJSONArray("plan");

        } catch (Exception e) {
            LOGGER.info(ERROR_JSON);
        }

        return planArray;
    }


    @Override
    public JSONArray getTasksArrayFromJSON(String path, int day) {

        JSONArray tasksArray = null;
        try {
            JSONObject obj = new JSONObject(fileToString(path));

            JSONArray planArray = obj.getJSONArray("plan");
            for (int i = 0; i < planArray.length(); i++) {
                if (planArray.getJSONObject(i).getInt("day") == day) {
                    tasksArray = planArray.getJSONObject(i).getJSONArray("tasks");
                }
            }

        } catch (Exception e) {
            LOGGER.info(ERROR_JSON);
        }
        return tasksArray;
    }


    @Override
    public boolean isAllTasksOpenByDay(int day) {
        LocalDate today = LocalDate.now();
        int dayCalendar;

        boolean result = true;
        JSONArray tasksArray = getTasksArrayFromJSON(R.TESTDATA.get("MYFITNESSPAL_101_JSONFILE_PATH"), day);
        ArrayList<String> list = new ArrayList<>();
        int n = tasksArray.length();
        int i = 0;
        for (; i < n; i++) {
            ExtendedWebElement taskTitle = taskTitleByText.format(tasksArray.getJSONObject(i).getString("task"));
            swipe(taskTitle, Direction.UP, TWENTY_COUNT, MEDIUM_SPEED);
            swipeUp(1, MEDIUM_SPEED);
            taskTitle.click();
            if (tasksArray.getJSONObject(i).getString("task").contains(LOG) || tasksArray.getJSONObject(i).getString("task").contains(TIP_OF_DAY)) {
                DiaryPageBase diaryPageBase = initPage(getDriver(), DiaryPageBase.class);
                closeCompleteTasksMessageBoxIfPresent();
                if (!diaryPageBase.isPageOpened()) {
                    list.add(tasksArray.getJSONObject(i).getString("title"));
                    result = false;
                } else {
                    diaryPageBase.openPageFromDownMenuByName(DownMenuElement.PLANS);
                    dayCalendar = today.getDayOfMonth();
                    dayCalendar = dayCalendar + (day - 1);
                    datePicker.setDay(dayCalendar);
                }
            } else {
                PlansDetailsPageBase plansDetailsPageBase = initPage(getDriver(), PlansDetailsPageBase.class);
                if (!plansDetailsPageBase.isPageOpened(tasksArray.getJSONObject(i).getString("pageName"),
                        tasksArray.getJSONObject(i).getString("title"))) {
                    list.add(tasksArray.getJSONObject(i).getString("title"));
                    result = false;
                } else {
                    goBack();
                }

            }
        }

        dayCalendar = today.getDayOfMonth();
        dayCalendar = dayCalendar + day;
        datePicker.setDay(dayCalendar);

        for (String title : list
        ) {
            LOGGER.info("{} day: false; task title: {}", day, title);
        }

        return result;
    }

    @Override
    public boolean isSurveyTitleAtTheBottom() {
        Point point = getLocationElement();
        swipeUp(1, MEDIUM_SPEED);
        return getLocationElement().getY() == point.getY();
    }

    @Override
    public boolean isLoggedWorkoutConfirmMsgPresent() {
        return workoutLoggedMessage.isElementPresent(TIMEOUT_TEN) &&
                workoutLoggedMessage.getText().equals(WORKOUT_LOGGED);
    }


    @Override
    public LogWorkoutPageBase clickLogWorkoutButton() {
        logWorkoutButton.click(TIMEOUT_TEN);
        return initPage(getDriver(), LogWorkoutPageBase.class);
    }


    @Override
    public DiaryPageBase clickViewButton() {
        viewButton.click(TIMEOUT_TEN);
        return initPage(getDriver(), DiaryPageBase.class);
    }


    @Override
    public PlansHubPageBase clickOnPlusSign() {
        addPlansPlusButton.click(TIMEOUT_FIFTEEN);
        return initPage(getDriver(), PlansHubPageBase.class);
    }

    @Override
    public PlansHubPageBase endPlan() {
        moreMenu.click(TIMEOUT_TEN);
        itemByText.format(END_PLAN).click(TIMEOUT_TEN);
        itemByText.format(END).click(TIMEOUT_TEN);
        return initPage(getDriver(), PlansHubPageBase.class);
    }


    @Override
    public PlansTaskManagerPageBase closeWelcomeMessageIfPresent(int timeout) {
        welcomeActionButton.clickIfPresent(timeout);
        return initPage(getDriver(), PlansTaskManagerPageBase.class);
    }

    @Override
    public PlansTaskManagerPageBase swipeToSurveyTitle(int timeout) {
        swipe(takeTheSurveyTitle, plansContainer, Direction.UP, FORTY_COUNT, FAST_SPEED);
        swipeUp(1, MEDIUM_SPEED);
        return initPage(getDriver(), PlansTaskManagerPageBase.class);
    }

    @Override
    public boolean isSectionSurveyPresent(int timeout) {
        return surveyTitle.isElementPresent(timeout) &&
                whatDoYouThinkTitle.isElementPresent(timeout) &&
                takeTheSurveyTitle.isElementPresent(timeout);
    }

    @Override
    public Point getLocationElement() {
        return takeTheSurveyTitle.getLocation();
    }

}
