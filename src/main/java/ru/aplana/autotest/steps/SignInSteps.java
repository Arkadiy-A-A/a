package ru.aplana.autotest.steps;

import cucumber.api.java.ru.Когда;
import ru.aplana.autotest.pages.SignFormWindow;

public class SignInSteps {
    SignFormWindow signInWindow = new SignFormWindow();

    @Когда("выбрать авторизацию по e-mail")
    public void авторизация_email(){
        signInWindow.clickEnterByEmail();
    }

    @Когда("ввести логин-email {string}")
    public void ввести_логин(String email){
        signInWindow.setEmailField(email);
    }

    @Когда("ввести пароль {string}")
    public void ввести_пароль(String password){
        signInWindow.setPasswordFieldl(password);
    }

    @Когда("выполнить авторизацию")
    public void выполнить_авторизацию(){
        signInWindow.clickSignInButton();
    }

}
