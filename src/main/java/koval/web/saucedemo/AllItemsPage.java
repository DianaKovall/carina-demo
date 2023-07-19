package koval.web.saucedemo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import koval.video.web.saucedemo.SortOptions;
import koval.web.saucedemo.modals.MenuModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class AllItemsPage extends AbstractPage {

    @FindBy(xpath = "//*[@class=\"inventory_item_name\"]")
    List<ExtendedWebElement> itemsNameList;

    @FindBy(xpath = "//*[@class=\"inventory_item_price\"]")
    List<ExtendedWebElement> itemsPriceList;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span")
    ExtendedWebElement selectedOptionContainer;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select/option[@value='%s']")
    ExtendedWebElement sortOption;

    @FindBy(id = "shopping_cart_container")
    ExtendedWebElement cartButton;

    @FindBy(id = "react-burger-menu-btn")
    MenuModal menuModal;


    public AllItemsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLogged() {
        return menuModal.isUIObjectPresent() &&
                cartButton.isElementPresent();
    }

    public AllItemsPage selectSortingOption(SortOptions sortOptions) {
        selectedOptionContainer.click();
        sortOption.format(sortOptions.getValue()).click();
        return new AllItemsPage(driver);
    }

    private List<String> getItemsNameList() {
        List<String> listOfItemsName = new ArrayList<>();

        for (ExtendedWebElement itemName : itemsNameList) {
            listOfItemsName.add(itemName.getText());
        }
        return listOfItemsName;
    }

    private List<String> getItemsPriceList() {
        List<String> listOfItemsPrice = new ArrayList<>();

        for (ExtendedWebElement itemName : itemsPriceList) {
            listOfItemsPrice.add(itemName.getText().replaceAll("\\$", ""));
        }
        return listOfItemsPrice;
    }

    public List<String> getItemsListByOption(SortOptions sortOptions) {

        switch (sortOptions) {
            case A_TO_Z:
            case Z_TO_A: {
                return getItemsNameList();
            }
            case HIGH_TO_LOW:
            case LOW_TO_HIGH: {
                return getItemsPriceList();
            }
        }
        return Collections.singletonList("[ ALL ITEMS PAGE ] Selected option is wrong!");
    }


    public List<String> getSortedItemsListByOption(SortOptions sortOptions) {

        List<String> listOfSortedItems;

        switch (sortOptions) {
            case A_TO_Z: {
                listOfSortedItems = getItemsNameList().stream().sorted().collect(Collectors.toList());
                return listOfSortedItems;
            }
            case Z_TO_A: {
                listOfSortedItems = getItemsNameList().stream().sorted().collect(Collectors.toList());
                Collections.reverse(listOfSortedItems);
                return listOfSortedItems;
            }
            case HIGH_TO_LOW: {
                List<Double> listOfItemsPrice = getItemsPriceList().stream().map(item -> item.replaceAll("\\$", "")).map(Double::parseDouble).collect(Collectors.toList());
                listOfSortedItems = listOfItemsPrice.stream().sorted().map(Object::toString).collect(Collectors.toList());
                Collections.reverse(listOfSortedItems);
                return listOfSortedItems;
            }
            case LOW_TO_HIGH: {
                List<Double> listOfItemsPrice = getItemsPriceList().stream().map(item -> item.replaceAll("\\$", "")).map(Double::parseDouble).collect(Collectors.toList());
                listOfSortedItems = listOfItemsPrice.stream().sorted().map(Object::toString).collect(Collectors.toList());
                return listOfSortedItems;
            }
        }
        return Collections.singletonList("[ ALL ITEMS PAGE ] Selected option is wrong!");
    }


}
