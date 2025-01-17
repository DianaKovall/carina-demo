package koval.mobile.myfitnesspal.gui.ios.actions.addExercise;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.downMenuPages.DiaryPageBase;
import koval.mobile.myfitnesspal.gui.common.actions.addExercise.NewCardioExercisePageBase;
import koval.mobile.myfitnesspal.service.factories.exerciseFactory.CardioExercise;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = NewCardioExercisePageBase.class)
public class NewCardioExerciseExercisePage extends NewCardioExercisePageBase {

    public NewCardioExerciseExercisePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public DiaryPageBase createAnExercise(CardioExercise cardioExercise) {
        throw new NotImplementedException();
    }
}
