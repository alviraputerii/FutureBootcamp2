package org.example.app.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.example.app.utils.Utility;

public class OriYugiOhCardDetailPage extends Utility {

    @FindBy(xpath = "//header[@id='broad_title']//h1")
    WebElementFacade textCardName;

    @FindBy(xpath = "//b[contains(text(),'Attribute')]/parent::span/following-sibling::span")
    WebElementFacade textAttribute;

    @FindBy(xpath = "(//span[@class='item_box_value'])[2]")
    WebElementFacade textRank;

    @FindBy(xpath = "//b[contains(text(),'Monster Type')]/ancestor::div[1]")
    WebElementFacade textMonsterType;

    @FindBy(xpath = "//b[contains(text(),'Card Type')]/ancestor::div[1]")
    WebElementFacade textCardType;

    @FindBy(xpath = "//b[contains(text(),'ATK')]/parent::span/following-sibling::span")
    WebElementFacade textAtk;

    @FindBy(xpath = "//b[contains(text(),'DEF')]/parent::span/following-sibling::span")
    WebElementFacade textDef;

    @FindBy(xpath = "//b[contains(text(),'Card Text')]/ancestor::div[2]")
    WebElementFacade textCardEffects;

    @FindBy(xpath = "//b[contains(text(),'Pendulum Effect')]/ancestor::div[2]")
    WebElementFacade textPendulumEffects;

    public String getCardName() {
        return getTextByWebElementFacade(textCardName);
    }

    public String getAttribute() {
        return getTextByWebElementFacade(textAttribute);
    }

    public String getRank() {
        return getTextByWebElementFacade(textRank);
    }

    public String getMonsterType() {
        return getTextByWebElementFacade(textMonsterType).substring(13);
    }

    public String getCardType() {
        String[] data = getTextByWebElementFacade(textCardType).split(" ");
        return data[1];
    }

    public String getAtk() {
        return getTextByWebElementFacade(textAtk);
    }

    public String getDef() {
        return getTextByWebElementFacade(textDef);
    }

    public String getCardEffects() {
        return getTextByWebElementFacade(textCardEffects).substring(10).replaceAll("\\s", "");
    }

    public String getPendulumEffects() {
        return getTextByWebElementFacade(textPendulumEffects).substring(16).replaceAll("\\s", "");
    }

}