package ru.aplana.autotest.pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.aplana.autotest.util.Product;

import java.util.Iterator;
import java.util.List;

import static ru.aplana.autotest.pages.ProductsPage.listProductCart;
import static ru.aplana.autotest.util.DataUtils.convertPriceInInteger;
import static ru.aplana.autotest.util.Product.sumPrice;

public class CartPage extends BasePage {


    @FindBy(xpath = "//div[@class='main split-item']")
    private List<WebElement> listOfProducts;

    @FindBy(xpath = "//span[@data-test-id='total-qty-block']")
    private WebElement counterCart;

    @FindBy(xpath = "//div[@data-test-id='total-price-block']//span[@class='main']")
    private WebElement priceTotal;

    @FindBy(xpath = "//*[@data-test-id='cart-delete-selected-btn']")
    private WebElement buttonDeleteAllProduct;

    @FindBy(xpath = "//*[@data-test-id='checkcart-confirm-modal-confirm-button']")
    private WebElement buttonDeleteConfirm;

    @FindBy(xpath = "//h1[@class='cart-title']")
    private WebElement cartEmpty;



    public void checkProductCart(){
        String realName;
        int realPrice;
        Product productFromList;
        Iterator<Product> productIterator = listProductCart.listIterator();
        while (productIterator.hasNext()){
            productFromList = productIterator.next();
            for (WebElement realProduct: listOfProducts) {
                realName = realProduct.findElement(By.xpath(".//a[@data-test-id='cart-item-title']")).getText().trim();
                realPrice = convertPriceInInteger(realProduct.findElement(By.xpath(".//span[@class='price-number']/span")).getText());
                if(realPrice == productFromList.getProductPrice() && realName.equals(productFromList.getProductName())) {
                    productIterator.remove();
                    break;
                }
            }
        }

        Assert.assertTrue("Некоторые продукты не были найдены", listProductCart.isEmpty());
    }


    public void checkSumPriceToCart(){
        Assert.assertEquals("Итогавая сумма не совпадает", convertPriceInInteger(priceTotal.getText()), sumPrice);
    }


    public void deleteAllProduct(){
        waitElementClickable(buttonDeleteAllProduct).click();
        waitElementClickable(buttonDeleteConfirm).click();
        sumPrice = 0;
    }

    public void checkCartEmpty(){
        Assert.assertTrue("Корзина не пуста", waitForTextToElement(cartEmpty, "Корзина пуста"));
    }

}
