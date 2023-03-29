package koval.mobile.myfitnesspal.gui.ios.searchFood.tabsCreatePages.myMeals;


import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.mobile.myfitnesspal.gui.common.searchFood.SearchFoodPageBase;
import koval.mobile.myfitnesspal.gui.common.searchFood.tabsCreatePages.myMeals.CreateMealPageBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CreateMealPageBase.class)
public class CreateMealPage extends CreateMealPageBase {


    public CreateMealPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        throw new NotImplementedException();
    }


    @Override
    public SearchFoodPageBase createMeal(String mealName) {
        throw new NotImplementedException();
    }

    @Override
    public SearchFoodPageBase clickSaveButton() {
        throw new NotImplementedException();
    }

}
