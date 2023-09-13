package koval.video.mobile.tabletkiua.services.enums;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public abstract class MyAbstractPage extends AbstractPage implements IConstantUtils {
    public MyAbstractPage(WebDriver driver) {
        super(driver);
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


}
