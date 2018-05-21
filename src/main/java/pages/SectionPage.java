package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class SectionPage extends BasePage {
    @FindBy(xpath = "//a[@class='eLeftMainMenu_Title' or @class='eLeftMainMenu_Link']")
    private  List<WebElement> categoryItems;

    public SectionPage(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public void selectCategoryItem(String value){
        selectItem(value,categoryItems);
    }

}
