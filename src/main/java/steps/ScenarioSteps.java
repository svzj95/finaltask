package steps;

import cucumber.api.java.en.When;

public class ScenarioSteps {
    private MainSteps mainSteps = new MainSteps();
    private SectionSteps sectionSteps = new SectionSteps();
    private CategorySteps categorySteps = new CategorySteps();
    private GoodsSteps goodsSteps = new GoodsSteps();
    private CartSteps cartSteps = new CartSteps();

    @When("^Выбрать пункт меню – (.+)")
    public void selectMainMenuItem(String value){
        mainSteps.selectMainMenuItem(value);
    }

    @When("Выбрать категорию – (.+)")
    public void selectCategoryItem(String value){
        sectionSteps.selectCategoryItem(value);
    }

    @When("^Выбрать производителя – (.+)")
    public void selectVendor(String value){
        categorySteps.selectVendor(value);
    }

    @When("Заполнить цена от – (.+) до \\\"([^\\\"]*)\\\"")
    public void setPrice(String from, String to) {
        goodsSteps.setPrice(from,to);
    }

    @When("^Добавить в коризну нечетные товары")
    public void addOddGoddsToCart(){
        goodsSteps.addOddGoddsToCart();
    }

    @When("Переход в корзину")
    public void goToCart(){
        goodsSteps.goToCart();
    }

    @When("Проверка товаров")
    public void checkGoods(){
        cartSteps.checkGoods();
    }

    @When("Очистить корзину")
    public void clearCart(){
        cartSteps.clearCart();
    }

    @When("Проверить пуста ли корзина")
    public void checkIsCartEmpty() {
        cartSteps.checkIsCartEmpty();
    }
}
