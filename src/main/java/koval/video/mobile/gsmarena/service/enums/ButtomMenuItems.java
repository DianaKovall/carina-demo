package koval.video.mobile.gsmarena.service.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.NewsPageBase;
import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.PhonesPageBase;
import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.ReviewsPageBase;
import koval.video.mobile.gsmarena.gui.common.buttomMenuPages.VideosPageBase;

public enum ButtomMenuItems {

    NEWS("news", NewsPageBase.class),
    REVIEWS("reviews", ReviewsPageBase.class),
    PHONES("phones", PhonesPageBase.class),
    VIDEOS("videos", VideosPageBase.class);


    private final String idPage;
    private final Class<? extends AbstractPage> className;

    ButtomMenuItems(String idPage, Class<? extends AbstractPage> className) {
        this.idPage = idPage;
        this.className = className;
    }

    public String getIdPage() {
        return idPage;
    }

    public Class<? extends AbstractPage> getClassName() {
        return className;
    }
}
