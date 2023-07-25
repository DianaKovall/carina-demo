package koval.video.web.gsmarena;


import com.beust.ah.A;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import koval.video.web.gsmarena.pages.*;
import koval.video.web.gsmarena.modals.LoginModal;
import koval.video.web.gsmarena.pages.menu.ProfilePage;
import koval.video.web.gsmarena.service.enums.BrandOption;
import koval.video.web.gsmarena.service.enums.Size;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
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
        BrandOption brandOption = BrandOption.SAMSUNG;
        SearchResultsPage searchResultsPage = homePage.searchForItem(brandOption.getBrandOption());
        Assert.assertTrue(searchResultsPage.isPageOpened(brandOption),
                String.format("[ SEARCH RESULTS PAGE ] Search results page is not opened! item: %s", brandOption));
        Assert.assertTrue(searchResultsPage.areResultsContainExpectedItems(brandOption),
                String.format("[ SEARCH RESULTS PAGE ] Search results does not contain item: %s", brandOption));

    }


    @Test(groups = "login")
    @MethodOwner(owner = "dkoval")
    public void addToCartTest() {
        HomePage homePage = new HomePage(getDriver());
        MerchHomePage merchHomePage = homePage.clickOnMerchButton();
        merchHomePage.open();
        DetailedProductPage detailedProductPage = merchHomePage.clickOnSeeMoreButton();

        Size size = Size.M;
        String expectedStandardColor = "ASPHALT";
        int expectedCartQuantity = 1;
        String expectedProductPrice = detailedProductPage.getProductPrice();
        String expectedProductName = String.format("%s - %s / %s", detailedProductPage.getProductName(), size, expectedStandardColor);

        detailedProductPage.selectSize(size);
        AddedToCartPage addedToCartPage = detailedProductPage.addToCart();

        int actualCartQuantity = addedToCartPage.getCartQuantity();
        String actualProductName = addedToCartPage.getProductNameFromCart();
        String actualProductPrice = addedToCartPage.getProductPriceFromCart();

        Assert.assertEquals(actualCartQuantity, expectedCartQuantity, "[ ADDED TO CART PAGE ] cart quantity is not as expected!");
        Assert.assertEquals(actualProductName, expectedProductName, "[ ADDED TO CART PAGE ] product name is not as expected!");
        Assert.assertEquals(actualProductPrice, expectedProductPrice, "[ ADDED TO CART PAGE ] product price is not as expected!");

    }

    @Test
    @MethodOwner(owner = "dkoval")
    public void forgotPasswordTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage.open();
        LoginModal loginModal = welcomePage.clickOnLoginButton();

        ForgottenPasswordPage forgottenPasswordPage = loginModal.clickOnForgotPasswordLink();
        forgottenPasswordPage.submitEmail();
        Assert.assertTrue(forgottenPasswordPage.isResetMessagePresent(),
                "[ FORGOTTEN PAGE ] The reset password massage is not present!");

    }

    @Test(groups = "login")
    @MethodOwner(owner = "dkoval")
    public void addToWishListTest() {
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


    @Test(groups = "login")
    @MethodOwner(owner = "dkoval")
    public void sortTest() {
        HomePage homePage = new HomePage(getDriver());
        PhoneFinderPage phoneFinderPage = homePage.clickSearchAdvancedButton();

        BrandOption brandOption = BrandOption.APPLE;
        phoneFinderPage.selectBrandOption(brandOption);
        SearchResultsPage searchResultsPage = phoneFinderPage.clickOnShowButton();
        Assert.assertTrue(searchResultsPage.areResultsContainExpectedItems(brandOption),
                "[ SEARCH RESULTS PAGE ] Products were not sorted correctly!");
    }


}
