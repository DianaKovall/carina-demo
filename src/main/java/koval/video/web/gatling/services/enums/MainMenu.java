package koval.video.web.gatling.services.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.video.web.gatling.pages.menuPages.AllProductsPage;
import koval.video.web.gatling.pages.menuPages.ForHerPage;
import koval.video.web.gatling.pages.menuPages.ForHimPage;
import koval.video.web.gatling.pages.menuPages.UnisexPage;

public enum MainMenu {

    ALL_PRODUCTS("All Products", AllProductsPage.class),
    FOR_HIM("For Him", ForHimPage.class),
    FOR_HER("For Her", ForHerPage.class),
    UNISEX("Unisex", UnisexPage.class);


    public String getPageName() {
        return pageName;
    }

    public Class<? extends AbstractPage> getClassName() {
        return className;
    }

    final String pageName;
    final Class<? extends AbstractPage> className;

    MainMenu(String pageName, Class<? extends AbstractPage> className) {
    this.pageName = pageName;
    this.className = className;
    }


}
