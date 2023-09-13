package koval.video.mobile.gsmarena.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.video.mobile.gsmarena.gui.common.phoneTabs.BrandsPageBase;
import koval.video.mobile.gsmarena.gui.common.phoneTabs.HistoryPageBase;
import koval.video.mobile.gsmarena.gui.common.phoneTabs.phoneFinder.PhoneFinderPageBase;
import koval.video.mobile.gsmarena.gui.common.phoneTabs.PopularPageBase;

public enum PhoneTabs {
    POPULAR("POPULAR", PopularPageBase.class),
    BRANDS("BRANDS", BrandsPageBase.class),

    PHONE_FINDER("PHONE FINDER",PhoneFinderPageBase.class),

    HISTORY("HISTORY", HistoryPageBase.class);


    private final Class<? extends AbstractPage> className;
    private final String tabName;
    PhoneTabs(String tabName, Class<? extends AbstractPage> className) {
        this.className=className;
        this.tabName=tabName;
    }

    public Class<? extends AbstractPage> getClassName() {
        return className;
    }

    public String getTabName() {
        return tabName;
    }
}
