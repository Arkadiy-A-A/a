package ru.aplana.autotest.steps;

import cucumber.api.java.ru.Когда;
import ru.aplana.autotest.pages.CartPage;

public class CartSteps {

    CartPage cartPage = new CartPage();

    @Когда("выполнить проверку добавленных товаров в корзине")
    public void checkProductCart(){
        cartPage.checkProductCart();
    }

    @Когда("выполнить проверку итоговой суммы")
    public void checkSumPriceToCart(){
        cartPage.checkSumPriceToCart();
    }

    @Когда("очистить корзину")
    public void deleteAllProduct(){
        cartPage.deleteAllProduct();
    }

    @Когда("проверить корзину на пустоту")
    public void checkCartEmpty(){
        cartPage.checkCartEmpty();
    }
}
