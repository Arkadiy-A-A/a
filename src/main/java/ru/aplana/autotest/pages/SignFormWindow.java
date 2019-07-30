package ru.aplana.autotest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignFormWindow extends BasePage {

    @FindBy(xpath = "//a[text()='Войти по почте']")
    public WebElement enterByEmail;

    @FindBy(xpath = "//input[@data-test-id='emailField']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@data-test-id='passwordField']")
    public WebElement passwordFieldl;

    @FindBy(xpath = "//button[@data-test-id='loginFormSubmitButton']")
    public WebElement signInButton;

    public void clickEnterByEmail(){
        waitElementClickable(enterByEmail).click();
    }

    public void setEmailField (String email){
        waitElementClickable(emailField).sendKeys(email);
    }

    public void setPasswordFieldl (String password){
        waitElementClickable(passwordFieldl).sendKeys(password);
    }

    public void clickSignInButton(){
        waitElementClickable(signInButton).click();
    }
}
