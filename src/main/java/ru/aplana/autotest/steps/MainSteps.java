package ru.aplana.autotest.steps;

import cucumber.api.java.ru.Когда;
import ru.aplana.autotest.pages.MainPage;

public class MainSteps {
    MainPage mainPage = new MainPage();

    @Когда("закрыть сообщение о cookies")
    public void закрыть_сообщение_о_cookies() {
        mainPage.closeMessageCookies();
    }

    @Когда("выполнен вызов окна авторизации")
    public void stepGoToSignIn() {
        mainPage.goToSignIn();
    }

    @Когда("выполнить поиск {string}")
    public void searchByText(String searchedText){
        mainPage.inputSearch(searchedText);
    }

    @Когда("активировать поиск")
    public void goSearch (){
        mainPage.goSearch();
    }

    @Когда("проверить успешность авторизации")
    public void testLogOn(){
        mainPage.testLogOn();
    }

    @Когда("выполнить выход")
    public void выполнить_выход(){
        mainPage.goToSignOut();
    }
}
