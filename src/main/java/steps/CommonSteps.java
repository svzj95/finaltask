package steps;

import io.qameta.allure.Step;
import pages.BasePage;
import pages.MainPage;

class CommonSteps {
    @Step("Переход в корзину")
    void goToCart(){
        new BasePage().goToCart();
    }

    @Step("Выбрать пункт меню – {0}")
    void selectMainMenuItem(String value){
        new MainPage().selectMenuItem(value);
    }
}
