package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.BaseSteps;

import java.util.List;

public class CategoryPage extends BasePage {
    @FindBy(xpath = "//span[@class='eBottomRoll_Link']")
    private WebElement showAllVendors;

    @FindBy(xpath = "//*[@class='eFilterList_OptionLink']")
    private List<WebElement> vendors;

    @FindBy(xpath = "//input[@class='eFilterList_SearchInput']")
    private WebElement searchInput;

    public CategoryPage(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public void selectVendor(String value){
        if(isElementPresent(showAllVendors)) {
            showAllVendors.click();
            wait.until(ExpectedConditions.visibilityOf(searchInput));
        }
        String[] inputVendors = value.replaceAll("\\s","").split(",");
        for(String i : inputVendors){
            selectItem(i,vendors);
        }
    }
}
