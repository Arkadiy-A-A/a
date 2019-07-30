package ru.aplana.autotest.util;

public class DataUtils {

    public static int convertPriceInInteger(String price) {
        return Integer.parseInt(price.trim().replaceAll(" ", "").replace("\u20BD", ""));
    }

}
