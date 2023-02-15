package koval.myfit.mobile.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.myfit.mobile.gui.common.plusButtonPages.AddActivityPageBase;

public enum PlusButtonMenuElement {
    ADD_BLOOD_PRESSURE("Add blood pressure", 0, AbstractPage.class),
    ADD_WEIGHT("Add weight", 1, AbstractPage.class),
    ADD_ACTIVITY("Add activity", 2, AddActivityPageBase.class),
    TRACK_WORKOUT("Track workout", 3, AbstractPage.class);


    public final String pageName;
    public final int pageIndex;
    private final Class<? extends AbstractPage> className;

    PlusButtonMenuElement(String pageName, int pageIndex, Class<? extends AbstractPage> className) {
        this.pageName = pageName;
        this.pageIndex = pageIndex;
        this.className = className;
    }


    public String getPageName() {
        return pageName;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public Class<? extends AbstractPage> getClassName() {
        return className;
    }
}