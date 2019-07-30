package ru.aplana.autotest.util;


public class Product {

    public static int sumPrice = 0;

    private String productName;
    private int productPrice;


    public Product(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;

        sumPrice += productPrice;
    }


    public String getProductName() {
        return productName;
    }


    public int getProductPrice() {
        return productPrice;
    }
}
