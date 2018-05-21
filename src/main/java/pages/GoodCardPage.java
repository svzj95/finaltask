package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

class GoodCardPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'bSaleBlockButton')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//h1[@class='bItemName']")
    private WebElement titleGood;

    GoodCardPage(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    void addToCartAndBack(int i){
        isElementPresent(addToCartButton);
        BaseSteps.put("good"+i/2,titleGood.getText());
        addToCartButton.click();
        BaseSteps.getDriver().navigate().back();
    }

}
