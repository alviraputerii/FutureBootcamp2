package org.example.app.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.example.app.utils.Utility;
import org.openqa.selenium.By;

public class YugipediaCardDetailPage extends Utility {

    @FindBy(xpath = "//h1[@id='firstHeading']")
    WebElementFacade textCardName;

    @FindBy(xpath = "//a[contains(text(),'Attribute')]/parent::th/following-sibling::td/a")
    WebElementFacade textAttribute;

    @FindBy(xpath = "//table[@class='innertable']//tr[4]/td/a")
    WebElementFacade textRank;

    @FindBy(xpath = "//a[contains(text(),'Type')]/parent::th/following-sibling::td/a[1]")
    WebElementFacade textMonsterType;

    @FindBy(xpath = "//a[contains(text(),'Type')]/parent::th/following-sibling::td/a[2]")
    WebElementFacade textCardType;

    @FindBy(xpath = "//a[contains(text(),'ATK')]/parent::th/following-sibling::td/a[1]")
    WebElementFacade textAtk;

    @FindBy(xpath = "//a[contains(text(),'ATK')]/parent::th/following-sibling::td/a[2]")
    WebElementFacade textDef;

    String textCardEffectsNonPendulum = "//div[@class='lore']//p";

    String textCardEffectsPendulum = "//div[@class='lore']//dd[2]";

    @FindBy(xpath = "//div[@class='lore']//dd[1]")
    WebElementFacade textPendulumEffects;

    @FindBy(xpath = "//a[@title='Slifer the Sky Dragon']")
    WebElementFacade commandLinkSlifer;

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
        return getTextByWebElementFacade(textMonsterType);
    }

    public String getCardType() {
        return getTextByWebElementFacade(textCardType);
    }

    public String getAtk() {
        return getTextByWebElementFacade(textAtk);
    }

    public String getDef() {
        return getTextByWebElementFacade(textDef);
    }

    public String getCardEffects() {
        String xpath = getDriver().getCurrentUrl().contains("Performapal_Odd-Eyes_Synchron") ? textCardEffectsPendulum : textCardEffectsNonPendulum;
        WebElementFacade cardEffect = find(By.xpath(xpath));
        return getTextByWebElementFacade(cardEffect).replaceAll("\\s", "");
    }

    public String getPendulumEffects() {
        return getTextByWebElementFacade(textPendulumEffects).replaceAll("\\s", "");
    }

    public void clickCommandLinkSlifer(){
        clickByWebElementFacade(commandLinkSlifer);
    }

}