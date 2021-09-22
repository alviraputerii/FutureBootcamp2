package org.example.app.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.example.app.common.CommonAction;
import org.example.app.utils.Utility;

public class BliBliHomePage extends Utility {

    CommonAction commonAction;

    @FindBy(xpath = "//div[@class='searchbox']//input")
    WebElementFacade searchInput;

    public void openBlibliHomePage() {
        commonAction.openPage("https://www.blibli.com/");
    }

    public void inputSearchValue(String string){
        typeValueByWebElementFacade(searchInput, string);
    }
}