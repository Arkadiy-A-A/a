package ru.aplana.autotest.steps;

import cucumber.api.java.ru.Когда;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import ru.aplana.autotest.pages.ProductsPage;

import java.util.List;

public class ProductsSteps {
    ProductsPage productsPage = new ProductsPage();

    @Когда("установить максимальное значение цены продукта {string}")
    public void setMaxPriceLimit(String maxPrice) {
        productsPage.setMaxPriceLimit(maxPrice);
    }

    @Когда("добавить в корзину первые {string} {string} товаров")
    public void добавить_в_корзину(String count, String parity) {
        switch (parity) {
            case "нечетных":
                productsPage.addToCart(count, true);
                break;
            case "четных":
                productsPage.addToCart(count, false);
                break;
            default:
                Assert.fail("Параметра " + parity + " не существует");

        }
    }


    @Когда("^выбирать бренды$")
    public void выбираем_бренды(DataTable arg) {
        List<String> table = arg.asList();
        productsPage.selectBrand(table);
    }

    @Когда("перейти в корзину")
    public void goToCart() {
        productsPage.goToCart();
    }
}
