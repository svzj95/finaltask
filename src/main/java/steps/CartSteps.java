package steps;

import io.qameta.allure.Step;
import pages.CartPage;

class CartSteps {
    @Step("Проверка товаров")
    void checkGoods(){
        new CartPage().checkGoods();
    }

    @Step("Очистить корзину")
    void clearCart(){
        new CartPage().clearCart();
    }

    @Step("Проверить пуста ли корзина")
    void checkIsCartEmpty() {
        new CartPage().checkIsCartEmpty();
    }
}
