package koval.video.mobile.gsmarena.gui.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import koval.video.mobile.gsmarena.gui.common.DeviceInformationPageBase;
import koval.video.mobile.gsmarena.gui.common.SearchResultsPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static koval.video.mobile.gsmarena.service.IConstants.TWENTY_TIMEOUT;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchResultsPageBase.class)
public class SearchResultsPage extends SearchResultsPageBase {

    @FindBy(xpath = "//*[@resource-id=\"content\"]/android.widget.TextView[@text='\"%s\" results']")
    ExtendedWebElement title;

    @FindBy(xpath = "//*[@resource-id=\"latest-container\"]/android.view.View/android.view.View/android.view.View/android.view.View")
    List<ExtendedWebElement> searchedItemsList;

    @FindBy(xpath = "//android.view.View[@content-desc=\"MORE \uE944\"]/android.widget.TextView[1]")
    ExtendedWebElement moreButton;



    @FindBy(xpath = "//android.view.View[@content-desc=\"%s\"]")
    ExtendedWebElement deviceBlock;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(String searchKeyword) {
        return title.format(searchKeyword).isElementPresent(10);
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public List<String> getSearchedItemsToList() {
        List<String> listOfAllSearchedItems = new ArrayList<>();

       do
        {
            for (ExtendedWebElement searchedItem :
                    searchedItemsList) {
                listOfAllSearchedItems.add(searchedItem.getText());
            }
            swipe(moreButton);
        }
       while(!moreButton.isElementPresent(10));

        return listOfAllSearchedItems.stream().distinct().collect(Collectors.toList());
    }


    @Override
    public boolean isSearchedResultsAsExpected(String searchKeyword) {

        for (String searchedElement : getSearchedItemsToList()) {
            if (!searchedElement.contains(searchKeyword))
                return false;
        }
        return true;
    }

    @Override
    public DeviceInformationPageBase clickOnDeviceBlock(String deviceBlockString){
        deviceBlock.format(deviceBlockString).click(TWENTY_TIMEOUT);
        return initPage(getDriver(), DeviceInformationPageBase.class);
    }


}
