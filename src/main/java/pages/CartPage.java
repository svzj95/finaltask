package pages;

import com.google.common.base.Strings;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.BaseSteps;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//span[@class='eCartItem_nameValue']")
    private List<WebElement> goods;

    @FindBy(xpath = "//div[contains(@class,'jsRemoveAll')][1]")
    private WebElement buttonClearCarts;

    @FindBy(xpath = "//span[@class='jsInnerContentpage_title']")
    private WebElement cartTitleEmpty;

    @FindBy(xpath = "//div[contains(@class,'bCartPage')][1]")
    private WebElement divCartPagey;

    public CartPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void checkGoods() {
        List<String> titleGoods = new ArrayList<>();
        for (WebElement i : goods)
            titleGoods.add(i.getText());
        for (int i = 0; i < titleGoods.size(); i++) {
            if (!titleGoods.contains(BaseSteps.get("good" + String.valueOf(i))))
                Assert.fail("Не найден элемент " + goods.get(i).getText());
        }
    }

    public void clearCart(){
        isElementPresent(buttonClearCarts);
        Actions builder = new Actions(BaseSteps.getDriver());
        do{
            wait.until(ExpectedConditions.attributeToBe(divCartPagey, "class", "bCartPage\n" +
                    "\t\n" +
                    "\t"));
            builder.click(buttonClearCarts).perform();
        }
        while (isElementPresent(buttonClearCarts));
    }

    public void checkIsCartEmpty() {
        wait.until(ExpectedConditions.visibilityOf(cartTitleEmpty));
        Assert.assertTrue(cartTitleEmpty.getText().contains("пуста"));

    }
}
