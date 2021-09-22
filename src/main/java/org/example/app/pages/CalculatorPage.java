package org.example.app.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.example.app.utils.Utility;

import java.time.Duration;

public class CalculatorPage extends Utility {

    @FindBy(id = "pad_numeric")
    WebElementFacade padNumeric;

    public boolean waitUntilElementAppear() {
        return padNumeric
                .withTimeoutOf(Duration.ofSeconds(30))
                .waitUntilVisible()
                .isVisible();
    }

    public void clickNumber(int number) {
        String numberIdPath = "digit_%s";
        WebElementFacade invBtn = find(By.id("toggle_inv"));
        if(invBtn.isVisible()){
            waitABit(5000);
        }
        WebElementFacade numberBtn = find(By.id(String.format(numberIdPath, number)));
        numberBtn.click();

//        getAndroidDriver().getBatteryInfo();
    }

    public String getFormulaText(){
        WebElementFacade formula = find(org.openqa.selenium.By.id("formula"));
        return formula.getText().trim();
    }
}