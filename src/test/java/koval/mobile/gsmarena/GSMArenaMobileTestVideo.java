package koval.mobile.gsmarena;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import koval.mobile.gsmarena.gui.common.NewsPageBase;
import org.testng.annotations.Test;

public class GSMArenaMobileTestVideo implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "dkoval")
    public void loginTest() {
        NewsPageBase newsPageBase = initPage(getDriver(), NewsPageBase.class);
         newsPageBase.openBurgerMenu();
    }
}
