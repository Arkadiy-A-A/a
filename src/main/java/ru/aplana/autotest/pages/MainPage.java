package ru.aplana.autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static ru.aplana.autotest.steps.BaseSteps.getDriver;

public class MainPage extends BasePage {

    @FindBy(xpath = "//span[@data-test-id='header-my-ozon-title']")
    private WebElement enter;

    @FindBy(xpath = "//input[@data-test-id='header-search-input']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@data-test-id='header-search-go']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='cookies-info']//button")
    private WebElement closeCookiesButton;


    public void closeMessageCookies() {
        waitElementClickable(closeCookiesButton).click();
    }

    public void goToSignIn() {
        waitForTextToElement(enter, "Войти");
        waitElementVisibilityOf(enter);
        waitElementClickable(enter).click();
    }

    public void inputSearch(String searchText) {
        waitElementClickable(searchInput).click();
        searchInput.sendKeys(searchText);
    }

    public void goSearch() {
        waitElementClickable(searchButton).click();
    }

    public void testLogOn() {
        waitForTextToElement(enter, "Кабинет");
    }


    public void goToSignOut(){
        waitElementVisibilityOf(enter);
        waitForTextToElement(enter, "Кабинет");
        moveToElement(enter);
        WebElement element = getDriver().findElement(By.xpath(".//ul[@data-test-id='menu-show-dropdown']//li[5]//*[contains(text(),'Выйти')]"));
        waitElementClickable(waitElementVisibilityOf(element)).click();
    }

}
