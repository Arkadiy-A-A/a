package ru.aplana.autotest.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.aplana.autotest.util.Product;

import java.util.ArrayList;
import java.util.List;

import static ru.aplana.autotest.util.DataUtils.convertPriceInInteger;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//span[@data-test-id='header-my-ozon-title']")
    private WebElement enter;

    @FindBy(xpath = "//div[@data-test-id='filter-block-price']//input[@data-test-id='range-filter-to-input']")
    private WebElement maxPriceLimit;

    @FindBy(xpath = "//div[@class='active-filters']")
    private WebElement activeFilter;

    @FindBy(xpath = "//div[@data-index]")
    private List<WebElement> listOfProducts;

    @FindBy(xpath = "//span[@data-test-id='counter']")
    private WebElement counterCart;

    @FindBy(xpath = "//a[@data-test-id='header-cart']//span[@data-test-id='header-my-ozon-title']")
    private WebElement cart;

    @FindBy(xpath = "//span[@data-test-id='filter-block-brand-show-all']")
    private WebElement linkBrandFilter;

    @FindBy(xpath = "//form[@class='search-form']//input")
    private WebElement inputBrandFilter;


    public static List<Product> listProductCart = new ArrayList<>();


    public void setMaxPriceLimit(String maxPrice) {
        waitElementClickable(maxPriceLimit).sendKeys(Keys.CONTROL + "a");
        maxPriceLimit.sendKeys(maxPrice);
        maxPriceLimit.sendKeys(Keys.ENTER);
        checkFilterToAppear("Цена");
    }

    public void checkFilterToAppear(String text) {
        waitElementVisibilityOf(activeFilter);
        waitElementVisibilityOf(activeFilter.findElement(By.xpath(".//*[contains(text(), '"+ text +"')]")));
    }

    public void addToCart(String count, boolean parity) {
        List<WebElement> staticList = listOfProducts;
        WebElement productAddButton;
        WebElement productPrice;
        WebElement productName;
        int elementCounter = 0;
        for (int i = 0; i <= (Integer.valueOf(count) * 2); i++) {
            if (elementCounter == Integer.valueOf(count)) {
                return;
            }
            if (((i+1)%2 != 0) == parity) {
                productAddButton = staticList.get(i).findElement(By.xpath(".//button/span"));
                productPrice = staticList.get(i).findElement(By.xpath(".//span[@data-test-id='tile-price']"));
                productName = staticList.get(i).findElement(By.xpath(".//a[@data-test-id='tile-name']"));

                waitElementClickable(productAddButton).click();
                elementCounter++;
                Assert.assertTrue("Продукт " + (i+1) + " не был добавлен в корзину",
                        waitForTextToElement(counterCart, "" + elementCounter));

                listProductCart.add(new Product(productName.getText(), convertPriceInInteger(productPrice.getText())));

            }
        }

    }


    public void goToCart(){
        waitForTextToElement(enter, "Кабинет");
        waitForTextToElement(cart, "Корзина");
        waitElementClickable(cart).click();
    }


    public void selectBrand(List<String> brands) {
        waitElementClickable(linkBrandFilter).click();
        for (String brand : brands) {
            waitElementVisibilityOf(inputBrandFilter);
            inputBrandFilter.sendKeys(brand);
            inputBrandFilter.sendKeys(Keys.ENTER);
            checkFilterToAppear(brand);
        }
    }

}
