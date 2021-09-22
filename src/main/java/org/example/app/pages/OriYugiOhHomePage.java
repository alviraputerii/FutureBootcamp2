package org.example.app.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.example.app.common.CommonAction;
import org.example.app.utils.Utility;

public class OriYugiOhHomePage extends Utility {

    CommonAction commonAction;

    @FindBy(xpath = "//a[@class='cards']")
    WebElementFacade buttonCardSearch;

    public void openOriYugiOhHomePage() {
        commonAction.openPage("https://www.db.yugioh-card.com/yugiohdb/");
    }

    public void clickButtonCardSearch(){
        clickByWebElementFacade(buttonCardSearch);
    }
}