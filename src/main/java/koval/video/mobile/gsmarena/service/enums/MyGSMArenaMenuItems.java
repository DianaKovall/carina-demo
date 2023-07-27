package koval.video.mobile.gsmarena.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;

import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.NewsPageBase;
import koval.video.mobile.gsmarena.gui.common.burgerMenuPages.LoginPageBase;
import koval.video.mobile.gsmarena.gui.common.burgerMenuPages.NotificationsPageBase;
import koval.video.mobile.gsmarena.gui.common.burgerMenuPages.ProfilePageBase;

public enum MyGSMArenaMenuItems {
    PROFILE("Profile", ProfilePageBase.class),

    LOGIN("Profile", LoginPageBase.class),
    NOTIFICATIONS("Notifications", NotificationsPageBase.class),
    NEWS_TOPICS("News Topics", NewsPageBase.class);


    private final String pageName;
    private final Class<? extends AbstractPage> className;
    MyGSMArenaMenuItems(String pageName, Class<? extends AbstractPage> className) {
        this.pageName=pageName;
        this.className=className;
    }

    public String getPageName() {
        return pageName;
    }

    public Class<? extends AbstractPage> getClassName() {
        return className;
    }
}
