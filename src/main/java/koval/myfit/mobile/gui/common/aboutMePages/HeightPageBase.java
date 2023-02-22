package koval.myfit.mobile.gui.common.aboutMePages;

import koval.myfit.mobile.gui.MyAbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class HeightPageBase extends MyAbstractPage {

    public HeightPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract WeightPageBase setHeight(int centimeters);

    public abstract WeightPageBase setHeight(float centimeters);
}
