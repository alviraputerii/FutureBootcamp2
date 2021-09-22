package org.example.app.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://en.wikipedia.org/wiki/Main_Page")
public class WikipediaPage extends PageObject {

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElementFacade searchInput;

    @FindBy(xpath = "//h1[@id='firstHeading']")
    WebElementFacade searchedHeader;

    public void inputSearchValue(String string){
        searchInput.waitUntilVisible().typeAndEnter(string);
    }

    public String getHeaderResult(){
        return searchedHeader.getText();
    }
}