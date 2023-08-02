package koval.video.mobile.gsmarena.gui.android.phoneTabs.phoneFinder;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.phoneTabs.phoneFinder.PhoneFinderResultsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PhoneFinderResultsPageBase.class)
public class PhoneFinderResultsPage extends PhoneFinderResultsPageBase {

    @FindBy(xpath = "//*[@resource-id=\"container\"]/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView[2]")
    ExtendedWebElement resultsCount;

    @FindBy(xpath = "//*[@resource-id=\"container\"]/android.view.View/android.view.View/android.widget.ListView/android.view.View/android.view.View/android.view.View")
    List<ExtendedWebElement> resultsNameList;

    public PhoneFinderResultsPage(WebDriver driver) {
        super(driver);
    }


    public int getResultsCount() {
        return Integer.parseInt(resultsCount.getText());
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Override
    public List<String> getResultsList() {
        List<String> listOfResults = resultsNameList.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());

        int resultsCountString = getResultsCount();

        while (listOfResults.stream().distinct().count() < resultsCountString) {
            swipeUp(300);
            listOfResults.addAll(resultsNameList.stream().map(ExtendedWebElement::getText).collect(Collectors.toList()));
        }


        return listOfResults.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public boolean isProductSortedCorrectly(List<String> resultsNameString, String brandName) {

        for (String resultName :
                resultsNameString) {
            if (!resultName.contains(brandName)) {
                return false;
            }
        }
        return true;
    }


}
