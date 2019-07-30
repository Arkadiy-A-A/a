package ru.aplana.autotest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.aplana.autotest.steps.BaseSteps;

public class BasePage {
    private WebDriver driver = BaseSteps.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 30);
    private Actions actions = new Actions(driver);

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement waitElementClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitElementVisibilityOf(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitForTextToElement(WebElement element, String textToAppear) {
        return wait.until((ExpectedCondition<Boolean>) d ->
                element.getText().trim().replaceAll(" ", "").replaceAll(",", ".")
                        .equals(textToAppear.trim().replaceAll(" ", "")));
    }

    public void waitRefresh(WebElement element) {
         wait.until(ExpectedConditions.stalenessOf(element));
    }


    public WebElement scrollToElement(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return element;
    }

    public void jsonClickElement(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }

    public void mouseActionClick(WebElement element) {
        actions.moveToElement(element).click(element).build().perform();
    }

    public void moveToElement(WebElement element) {
        actions.moveToElement(element).build().perform();
    }

}
