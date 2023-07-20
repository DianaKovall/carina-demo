package koval.video.web.gatling;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import koval.video.web.gatling.pages.*;
import koval.video.web.gatling.pages.menuPages.AllProductsPage;
import koval.video.web.gatling.services.enums.MainMenu;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class GatlingWebTestVideo implements IAbstractTest {


    @BeforeMethod(onlyForGroups = "login")
    public void login() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage.open();
        LoginPage loginPage = welcomePage.clickOnLoginButton();
        HomePage homePage = loginPage.login();
    }

    @Test
    @MethodOwner(owner = "dkoval")
    public void loginTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage.open();
        LoginPage loginPage = welcomePage.clickOnLoginButton();
        HomePage homePage = loginPage.login();
        Assert.assertTrue(homePage.isUserLogged(), String.format("[ HOME PAGE ] User %s is not logged!", R.TESTDATA.get("gatling_username")));
    }

    @Test(groups = "login")
    @MethodOwner(owner = "dkoval")
    public void addToCartTest() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        HomePage homePage = new HomePage(getDriver());

        AllProductsPage allProductsPage = (AllProductsPage) homePage.getMainMenu().openPageFromMenu(MainMenu.ALL_PRODUCTS);
        String firstProductName = allProductsPage.getFirstProductName();
        String firstProductPrice = allProductsPage.getFirstProductPrice();
        int productQuantity = 1;

        allProductsPage.addFirstProductToCart();
        CartPage cartPage = allProductsPage.openCartPage();
        Assert.assertTrue(cartPage.isProductAdded(firstProductName), String.format("[ CART PAGE ] The product: %s was not added", firstProductName));

        Assert.assertEquals(cartPage.getProductPrice(), firstProductPrice, " [ CART PAGE ] price is not what expected!");
        Assert.assertEquals(cartPage.getProductQuantity(), productQuantity, " [ CART PAGE ] quantity is not what expected!");
    }

    @Test(groups = {"login"})
    @MethodOwner(owner = "dkoval")
    public void checkoutTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        HomePage homePage = new HomePage(getDriver());

        AllProductsPage allProductsPage = (AllProductsPage) homePage.getMainMenu().openPageFromMenu(MainMenu.ALL_PRODUCTS);
        allProductsPage.addFirstProductToCart();
        CartPage cartPage = allProductsPage.openCartPage();

        CheckoutConfirmationPage checkoutConfirmationPage = cartPage.clickOnCheckoutButton();
        Assert.assertTrue(checkoutConfirmationPage.isPageOpened(), "[ CHECK CONFIRMATION PAGE ] Check Confirmation Page is not opened!");
    }


}
