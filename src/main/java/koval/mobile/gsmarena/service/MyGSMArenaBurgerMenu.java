package koval.mobile.gsmarena.service;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.mobile.gsmarena.gui.android.burgerMenuPages.NewsTopicsPage;
import koval.mobile.gsmarena.gui.common.burgerMenuPages.LoginPageBase;
import koval.mobile.gsmarena.gui.common.burgerMenuPages.NotificationsPageBase;
import koval.mobile.gsmarena.gui.common.burgerMenuPages.ProfilePageBase;

public enum MyGSMArenaBurgerMenu {

    PROFILE("Profile", ProfilePageBase.class),

    LOGIN("Profile", LoginPageBase.class),

    NOTIFICATIONS("Notifications", NotificationsPageBase.class),
    NEWS_TOPICS("News Topics", NewsTopicsPage.class);

    private final String itemMenuName;
    private final Class<? extends AbstractPage> className;

    MyGSMArenaBurgerMenu(String itemMenuName, Class<? extends AbstractPage> className) {
        this.itemMenuName = itemMenuName;
        this.className = className;
    }

    public String getItemMenuName() {
        return itemMenuName;
    }


    public Class<? extends AbstractPage> getClassName() {
        return className;
    }

}
