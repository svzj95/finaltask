package steps;

import io.qameta.allure.Step;
import pages.CategoryPage;

class CategorySteps extends CommonSteps {
    @Step("Выбрать производителя – {0}")
    void selectVendor(String value){
        new CategoryPage().selectVendor(value);
    }
}
