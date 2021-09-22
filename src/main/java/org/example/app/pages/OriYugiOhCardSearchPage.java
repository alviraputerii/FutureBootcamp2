package org.example.app.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.example.app.utils.Utility;

public class OriYugiOhCardSearchPage extends Utility {

    @FindBy(xpath = "//input[@id='keyword']")
    WebElementFacade inputKeyword;

    private String result = "//dt[@class='box_card_name']//strong[contains(text(),'%s')]";

    public void inputSearchValue(String value) {
        typeValueByWebElementFacade(inputKeyword, value);
    }

    public void clickMatchResult(String value){
        clickByXpath(String.format(result, value));
    }

}