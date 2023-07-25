package koval.video.web.gatling.modals;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import koval.video.web.gatling.services.enums.MainMenu;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;


public class MenuModal extends AbstractUIObject {

    @FindBy(xpath = "/html/body/div/div/div[1]/ul/li/a[text()='%s']")
    ExtendedWebElement menuElement;

    public MenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AbstractPage openPageFromMenu(MainMenu mainMenu) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        menuElement.format(mainMenu.getPageName()).click();
        return mainMenu.getClassName().getDeclaredConstructor(WebDriver.class).newInstance(driver);
    }

}
