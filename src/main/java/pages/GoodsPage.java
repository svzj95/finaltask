package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.BaseSteps;

import java.util.List;

public class GoodsPage extends BasePage {
    @FindBy(xpath = "//div[@id='price_filter']/descendant::input")
    private List<WebElement> priceFromTo;

    @FindBy(xpath = "//div[@id='price_filter']/descendant::div[contains(@class,'bFlatButton')]")
    private WebElement applyButton;

    @FindBy(xpath = "//div[contains(@class,'bOneTile ')]")
    private List<WebElement> goods;

    public GoodsPage(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    private void sendKeys(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);
    }

    public void sendPriceFromTo(String from, String to) {
        if(!from.equals("")){
            sendKeys(priceFromTo.get(0),from);
        }
        if(!to.equals("")){
            sendKeys(priceFromTo.get(0),to);
        }
        wait.until(ExpectedConditions.visibilityOf(applyButton));
        applyButton.click();
    }

    public void addGoodsToCart(){
        int z = 0;
        for(int i=0;i<goods.size();i+=2,z++){
            goods.get(i).click();
            new GoodCardPage().addToCartAndBack(i);
        }
    }

}
