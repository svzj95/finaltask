package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *  Страничка с общими тегами
 */
public class BasePage {
    WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 3);


    @FindBy(xpath = "//span[@class='eHeaderCatalogButton_Text']")
    private WebElement allSectionsButton;

    @FindBy(xpath = "//span[@class='eOzonCatalog_1LevelLinkText']")
    private List<WebElement> elementAllSections;

    @FindBy(xpath = "//div[contains(@class,'eMyOzon_Item mCar')]/a")
    private WebElement iconCart;

    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    boolean isElementPresent(WebElement element) {
        try {
            BaseSteps.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        finally {
            BaseSteps.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    void selectFromAllSections(String value){
        allSectionsButton.click();
        this.selectItem(value,elementAllSections);

    }

    void selectItem(String value, List<WebElement> ListElements){
        for(WebElement i : ListElements){
            //System.out.println(i.getText().trim().replaceAll("\\d",""));
            if(i.getText().replaceAll("\\d","").trim().equalsIgnoreCase(value)){
                i.click();
                return;
            }
        }
        Assert.fail("Не найден элемент " + value);
    }

    public void goToCart(){
        iconCart.click();
    }
}
