package org.example.app.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.example.app.common.CommonAction;
import org.example.app.utils.Utility;

public class YugipediaHomePage extends Utility {

    CommonAction commonAction;

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElementFacade inputKeyword;

    public void openYugipediaHomePage() {
        commonAction.openPage("https://yugipedia.com/wiki/Yugipedia");
    }

    public void inputSearchValue(String value){
        typeValueByWebElementFacade(inputKeyword, value);
    }
}