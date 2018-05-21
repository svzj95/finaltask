package steps;

import io.qameta.allure.Step;
import pages.GoodsPage;

class GoodsSteps extends CommonSteps {
    @Step("Заполнить цена от – {0} до {1}")
    void setPrice(String from, String to) {
        new GoodsPage().sendPriceFromTo(from,to);
    }

    @Step("Добавить в коризну нечетные товары")
    void addOddGoddsToCart(){
        new GoodsPage().addGoodsToCart();
    }

}
