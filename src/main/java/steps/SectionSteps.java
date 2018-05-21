package steps;

import io.qameta.allure.Step;
import pages.SectionPage;

class SectionSteps {
    @Step("Выбрать категорию – {0}")
    void selectCategoryItem(String value){
        new SectionPage().selectCategoryItem(value);
    }
}
