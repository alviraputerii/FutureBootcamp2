package org.example.app.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.example.app.common.CommonAction;
import org.example.app.utils.Utility;
import org.openqa.selenium.support.FindBy;

public class SeleniumEasyPage extends Utility {

    CommonAction commonAction;

    @FindBy(name = "first_name")
    WebElementFacade firstName;

    @FindBy(name = "last_name")
    WebElementFacade lastName;

    @FindBy(name = "email")
    WebElementFacade email;

    public void openSeleniumEasyHomePage() {
        commonAction.openPage("https://www.seleniumeasy.com/test/input-form-demo.html");
    }

    public void typeFirstName(String string){
        typeValueWithoutEnterByWebElementFacade(firstName, string);
    }

    public void typeLastName(String string){
        typeValueWithoutEnterByWebElementFacade(lastName, string);
    }

    public void typeEmail(String string){
        typeValueWithoutEnterByWebElementFacade(email, string);
    }
}