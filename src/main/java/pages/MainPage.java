package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class MainPage extends BasePage {


    public MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public void selectMenuItem(String value){
        this.selectFromAllSections(value);
    }
}
