package koval.video.web.saucedemo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import koval.video.web.saucedemo.pages.LoginPage;
import koval.web.saucedemo.AllItemsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.List;


public class SaucedemoWebTest implements IAbstractTest {


    @Test
    @MethodOwner(owner = "dkoval")
    public void loginTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.enterValidCredentials();
        AllItemsPage allItemsPage = loginPage.login();
        Assert.assertTrue(allItemsPage.isUserLogged(), "[ ALL ITEMS ] User is not logged!");
    }


    @Test
    @MethodOwner(owner = "dkoval")
    public void sortProductsTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.enterValidCredentials();
        AllItemsPage allItemsPage = loginPage.login();

        SortOptions sortOptions = SortOptions.HIGH_TO_LOW;
        allItemsPage.selectSortingOption(sortOptions);
        List<String> actualListOfItemsByOption = allItemsPage.getItemsListByOption(sortOptions);

        List<String> expectedListOfItemsByOption = allItemsPage.getSortedItemsListByOption(sortOptions);

        Assert.assertEquals(actualListOfItemsByOption, expectedListOfItemsByOption,
                "[ ALL ITEMS PAGE ] Products are not sorted by selected option");



    }

}
