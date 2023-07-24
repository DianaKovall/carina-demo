package koval.video.web.gsmarena.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.video.web.gsmarena.service.enums.BrandOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static koval.video.web.gsmarena.service.IConstants.*;

public class PhoneFinderPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"body\"]/form/div[2]/div[1]/div/div[1]/button")
    ExtendedWebElement brandFilter;

    @FindBy(xpath = "//*[@id=\"body\"]/form/div[2]/div[1]/div/div[1]/div[1]/ul/li/a/span[text()='%s']")
    ExtendedWebElement brandOption;


    @FindBy(xpath = "//*[@id=\"body\"]/form/div[5]/span/input")
    ExtendedWebElement showButton;

    public PhoneFinderPage(WebDriver driver) {
        super(driver);
    }


    public PhoneFinderPage selectBrandOption(BrandOption brandOptionEnum) {
        brandFilter.click(FIFTEEN_TIMEOUT);
        brandOption.format(brandOptionEnum.getBrandOption()).click(FIFTEEN_TIMEOUT);
        return new PhoneFinderPage(driver);
    }

    public SearchResultsPage clickOnShowButton(){
        showButton.click();
        return new SearchResultsPage(driver);
    }



}
