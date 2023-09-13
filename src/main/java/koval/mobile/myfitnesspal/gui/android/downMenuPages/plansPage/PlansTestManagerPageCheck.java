package koval.mobile.myfitnesspal.gui.android.downMenuPages.plansPage;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.android.modal.DatePickerModal;
import koval.mobile.myfitnesspal.gui.android.modal.DownMenuModal;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansDetailsPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansHubPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansTaskManagerPageBase;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.PlansTestManagerPageBaseCheck;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.plansPage.workout.LogWorkoutPageBase;
import koval.mobile.myfitnesspal.gui.common.modal.DatePickerModalBase;
import koval.mobile.myfitnesspal.service.enums.DownMenuElement;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PlansTestManagerPageBaseCheck.class)
public class PlansTestManagerPageCheck extends PlansTestManagerPageBaseCheck {


    public PlansTestManagerPageCheck(WebDriver driver) {
        super(driver);
    }

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
            LOGGER.info("Error building JSON");
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
            LOGGER.info("Error building JSON");
        }

        return tasksArray;
    }


//    @Override
//    public PlansDetailsPageBase openTaskByDay(int day) {
//        LOGGER.info("{} day", day);
//
//        JSONArray tasksArray = getTasksArrayFromJSON("src/main/java/koval/mobile/myfitnesspal/service/JSON/MyFitnessPal101_7DaysPlan_Tasks.json", day);
//
//        int n = tasksArray.length();
//        for (int i = 0; i < n; i++) {
//            itemByText.format(tasksArray.getJSONObject(i).getString("task")).click();
//            driver.navigate().back();
//        }
//
//        return initPage(getDriver(), PlansDetailsPageBase.class);
//    }


    @Override
    public boolean isAllTasksOpenByDay(int day) {

        int dayCal = 11;
        JSONArray tasksArray = getTasksArrayFromJSON("src/main/java/koval/mobile/myfitnesspal/service/JSON/MyFitnessPal101_7DaysPlan_Tasks.json", day);

        int n = tasksArray.length();
        for (int i = 0; i < n; i++) {
            ExtendedWebElement taskTitle = itemByText.format(tasksArray.getJSONObject(i).getString("task"));
            swipe(taskTitle, Direction.UP, TWENTY_COUNT, MEDIUM_SPEED);
            swipeUp(1, MEDIUM_SPEED);
            taskTitle.click();
            if (tasksArray.getJSONObject(i).getString("task").contains("Log")) {
                DiaryPageBase diaryPageBase = initPage(getDriver(), DiaryPageBase.class);
                closeCompleteTasksMessageBoxIfPresent();
                if (!diaryPageBase.isPageOpened()) {
                    LOGGER.info("{} day: false", day);
                    return false;
                }
                diaryPageBase.openPageFromDownMenuByName(DownMenuElement.PLANS);
                dayCal++;
                datePicker.setDay(dayCal);
            } else {
                PlansDetailsPageBase plansDetailsPageBase = initPage(getDriver(), PlansDetailsPageBase.class);
                if (!plansDetailsPageBase.isPageOpened(tasksArray.getJSONObject(i).getString("pageName"),
                        tasksArray.getJSONObject(i).getString("title"))) {
                    LOGGER.info("{} day: false", day);
                    return false;
                }
                goBack();
            }

        }
        LOGGER.info("{} day: true", day);
        return true;
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
                workoutLoggedMessage.getText().equals("Workout logged.");
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
