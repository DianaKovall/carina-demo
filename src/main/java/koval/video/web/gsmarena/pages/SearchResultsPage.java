package koval.video.web.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.video.web.gsmarena.service.enums.BrandOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SearchResultsPage extends AbstractPage {

    @FindBy(xpath = "//*[@class=\"article-info\"]/div[2]//h1[contains(text(), 'Search results for \"%s\"')]")
    ExtendedWebElement title;


    @FindBy(xpath = "//*[@id=\"review-body\"]//ul/li//strong/span")
    List<ExtendedWebElement> listOfResults;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(BrandOption brandOption) {
        return title.format(brandOption.getBrandOption()).isElementPresent(20);
    }


    public boolean areResultsContainExpectedItems(BrandOption brandOption) {

        for (ExtendedWebElement listOfResult : listOfResults) {
            if (!listOfResult.getText().contains(brandOption.getBrandOption())) {
                return false;
            }
        }
        return true;
    }

    public DetailedDevicePage clickOnDevice() {
        if (listOfResults.isEmpty()) {
            Assert.fail("List of devices is empty!");
        }

        listOfResults.get(0).click(20);
        return new DetailedDevicePage(driver);
    }


}
