package koval.video.web.gsmarena;


import com.beust.ah.A;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import koval.video.web.gsmarena.pages.*;
import koval.video.web.gsmarena.modals.LoginModal;
import koval.video.web.gsmarena.pages.menu.ProfilePage;
import koval.video.web.gsmarena.service.enums.Size;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GSMArenaWebTestVideo implements IAbstractTest {


    @BeforeMethod(onlyForGroups = {"login"})
    public void login() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage.open();
        LoginModal loginModal = welcomePage.clickOnLoginButton();
        loginModal.login();
    }

    @Test
    @MethodOwner(owner = "dkoval")
    public void loginTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage.open();
        LoginModal loginModal = welcomePage.clickOnLoginButton();
        HomePage homePage = loginModal.login();
        String userName = R.TESTDATA.get("gsmarena_username");
        Assert.assertTrue(homePage.isUserLogged(userName), String.format("[ HOME PAGE ] User '%s' is not logged!", userName));
    }


    @Test(groups = "login")
    @MethodOwner(owner = "dkoval")
    public void searchTest() {

        HomePage homePage = new HomePage(getDriver());
        String itemName = "Samsung";
        SearchResultsPage searchResultsPage = homePage.searchForItem(itemName);
        Assert.assertTrue(searchResultsPage.isPageOpened(itemName),
                String.format("[ SEARCH RESULTS PAGE ] Search results page is not opened! item: %s", itemName));
        Assert.assertTrue(searchResultsPage.areResultsContainExpectedItems(itemName),
                String.format("[ SEARCH RESULTS PAGE ] Search results does not contain item: %s", itemName));

    }


    @Test(groups = "login")
    @MethodOwner(owner = "dkoval")
    public void addToCartTest() {
        HomePage homePage = new HomePage(getDriver());
        MerchHomePage merchHomePage = homePage.clickOnMerchButton();
        merchHomePage.open();
        DetailedProductPage detailedProductPage = merchHomePage.clickOnSeeMoreButton();

        Size size = Size.M;
        String expectedStandardColor="ASPHALT";
        int expectedCartQuantity = 1;
        String expectedProductPrice = detailedProductPage.getProductPrice();
        String expectedProductName= String.format("%s - %s / %s", detailedProductPage.getProductName(), size, expectedStandardColor);

        detailedProductPage.selectSize(size);
        AddedToCartPage addedToCartPage = detailedProductPage.addToCart();

        int actualCartQuantity =addedToCartPage.getCartQuantity();
        String actualProductName= addedToCartPage.getProductNameFromCart();
        String actualProductPrice= addedToCartPage.getProductPriceFromCart();

        Assert.assertEquals(actualCartQuantity, expectedCartQuantity, "[ ADDED TO CART PAGE ] cart quantity is not as expected!");
        Assert.assertEquals(actualProductName, expectedProductName, "[ ADDED TO CART PAGE ] product name is not as expected!");
        Assert.assertEquals(actualProductPrice, expectedProductPrice, "[ ADDED TO CART PAGE ] product price is not as expected!");

    }

    @Test
    @MethodOwner(owner="dkoval")
    public void forgotPasswordTest(){
        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage.open();
        LoginModal loginModal = welcomePage.clickOnLoginButton();

        ForgottenPasswordPage forgottenPasswordPage = loginModal.clickOnForgotPasswordLink();
        forgottenPasswordPage.submitEmail();
        Assert.assertTrue(forgottenPasswordPage.isResetMessagePresent(),
                "[ FORGOTTEN PAGE ] The reset password massage is not present!");

    }

    @Test(groups="login")
    @MethodOwner(owner = "dkoval")
    public void addToWishListTest(){
        HomePage homePage = new HomePage(getDriver());
        String deviceName = "Samsung";
        String deviceModel = "Galaxy A54";
        SearchResultsPage searchResultsPage = homePage.searchForItem(deviceModel);
        DetailedDevicePage detailedDevicePage = searchResultsPage.clickOnDevice();

        detailedDevicePage.clickOnBecomeFanButton();
        ProfilePage profilePage = detailedDevicePage.clickOnProfileButton();
        Assert.assertTrue(profilePage.isDeviceAddedToFavorite(deviceName, deviceModel),
                String.format("[ PROFILE PAGE ] device model: %s was not added to favorite!", deviceModel));
    }




}
