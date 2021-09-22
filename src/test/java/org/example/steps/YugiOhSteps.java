package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.example.app.common.CommonAction;
import org.example.app.data.YugiOhCardsData;
import org.example.app.pages.*;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class YugiOhSteps extends PageObject {
    CommonAction commonAction;
    OriYugiOhHomePage oriYugiOhHomePage;
    OriYugiOhCardSearchPage oriYugiOhCardSearchPage;
    OriYugiOhCardDetailPage oriYugiOhCardDetailPage;
    YugipediaHomePage yugipediaHomePage;
    YugipediaCardDetailPage yugipediaCardDetailPage;
    YugiOhCardsData oriData = new YugiOhCardsData();
    YugiOhCardsData yugipediaData = new YugiOhCardsData();

    @Given("open original Yugi-Oh home page")
    public void openOriginalYugiOhHomePage() {
        oriYugiOhHomePage.openOriYugiOhHomePage();
    }

    @And("original Yugi-Oh home page should be opened")
    public void originalYugiOhHomePageShouldBeOpened() {
        String url = "https://www.db.yugioh-card.com/yugiohdb/";
        assertThat("invalid page", commonAction.verifyPageIsOpened(url), equalTo(true));
    }

    @When("at original Yugi-Oh home page click button card search")
    public void atOriginalYugiOhHomePageClickButtonCardSearch() {
        oriYugiOhHomePage.clickButtonCardSearch();
    }

    @When("at original Yugi-Oh home page search for card {string}")
    public void atOriginalYugiOhHomePageSearchForCardCard(String value) {
        oriYugiOhCardSearchPage.inputSearchValue(value);
    }

    @When("at original Yugi-Oh card page click match result for {string}")
    public void atOriginalYugiOhCardPageClickMatchResult(String value) {
        try {
            oriYugiOhCardSearchPage.clickMatchResult(value);
            oriData.setFlagFailed(false);
        } catch (Exception e) {
            oriData.setFlagFailed(true);
        }
    }

    @When("switch to card details page")
    public void switchToCardDetailsPage() {
        if (!oriData.getFlagFailed().equals(true))
            commonAction.switchTabs();
    }

    @Then("get Yugi-Oh card's following information")
    public void getYugiOhCardSFollowingInformation(List<String> information) {
        if (!oriData.getFlagFailed().equals(true)) {
            for (String info : information) {
                switch (info) {
                    case "cardName":
                        oriData.setCardName(oriYugiOhCardDetailPage.getCardName());
                        System.out.println(oriData.getCardName());
                        break;
                    case "attribute":
                        oriData.setAttribute(oriYugiOhCardDetailPage.getAttribute());
                        System.out.println(oriData.getAttribute());
                        break;
                    case "rank/level":
                        oriData.setRank(oriYugiOhCardDetailPage.getRank());
                        System.out.println(oriData.getRank());
                        break;
                    case "monsterType":
                        oriData.setMonsterType(oriYugiOhCardDetailPage.getMonsterType());
                        System.out.println(oriData.getMonsterType());
                        break;
                    case "cardType":
                        oriData.setCardType(oriYugiOhCardDetailPage.getCardType());
                        System.out.println(oriData.getCardType());
                        if (oriData.getCardType().contains("Pendulum"))
                            oriData.setPendulumEffects(oriYugiOhCardDetailPage.getPendulumEffects());
                        System.out.println(oriData.getPendulumEffects());
                        break;
                    case "atk":
                        oriData.setAtk(oriYugiOhCardDetailPage.getAtk());
                        System.out.println(oriData.getAtk());
                        break;
                    case "def":
                        oriData.setDef(oriYugiOhCardDetailPage.getDef());
                        System.out.println(oriData.getDef());
                        break;
                    default:
                        oriData.setCardEffects(oriYugiOhCardDetailPage.getCardEffects());
                        System.out.println(oriData.getCardEffects());
                }
            }
        }
    }

    @Given("open wiki Yugipedia home page")
    public void openWikiYugipediaHomePage() {
        if (!oriData.getFlagFailed().equals(true))
            yugipediaHomePage.openYugipediaHomePage();
    }

    @And("wiki Yugipedia home page should be opened")
    public void wikiYugipediaHomePageShouldBeOpened() {
        if (!oriData.getFlagFailed().equals(true)) {
            String url = "https://yugipedia.com/wiki/Yugipedia";
            assertThat("invalid page", commonAction.verifyPageIsOpened(url), equalTo(true));
        }
    }

    @When("at wiki Yugipedia home page search for card {string}")
    public void atWikiYugipediaHomePageSearchForCardDarkMagician(String value) {
        if (!oriData.getFlagFailed().equals(true))
            yugipediaHomePage.inputSearchValue(value);
    }

    @Then("get wiki Yugipedia following information")
    public void getWikiYugipediaFollowingInformation(List<String> information) {
        if (!oriData.getFlagFailed().equals(true)) {
            if (getDriver().getCurrentUrl().contains("Slifer"))
                yugipediaCardDetailPage.clickCommandLinkSlifer();
            for (String info : information) {
                switch (info) {
                    case "cardName":
                        yugipediaData.setCardName(yugipediaCardDetailPage.getCardName());
                        System.out.println(yugipediaData.getCardName());
                        break;
                    case "attribute":
                        yugipediaData.setAttribute(yugipediaCardDetailPage.getAttribute());
                        System.out.println(yugipediaData.getAttribute());
                        break;
                    case "rank/level":
                        yugipediaData.setRank(yugipediaCardDetailPage.getRank());
                        System.out.println(yugipediaData.getRank());
                        break;
                    case "monsterType":
                        yugipediaData.setMonsterType(yugipediaCardDetailPage.getMonsterType());
                        System.out.println(yugipediaData.getMonsterType());
                        break;
                    case "cardType":
                        yugipediaData.setCardType(yugipediaCardDetailPage.getCardType());
                        System.out.println(yugipediaData.getCardType());
                        if (yugipediaData.getCardType().equalsIgnoreCase("pendulum"))
                            yugipediaData.setPendulumEffects(yugipediaCardDetailPage.getPendulumEffects());
                        System.out.println(yugipediaData.getPendulumEffects());
                        break;
                    case "atk":
                        yugipediaData.setAtk(yugipediaCardDetailPage.getAtk());
                        System.out.println(yugipediaData.getAtk());
                        break;
                    case "def":
                        yugipediaData.setDef(yugipediaCardDetailPage.getDef());
                        System.out.println(yugipediaData.getDef());
                        break;
                    default:
                        yugipediaData.setCardEffects(yugipediaCardDetailPage.getCardEffects());
                        System.out.println(yugipediaData.getCardEffects());
                }
            }
        }
    }

    @Then("compare the following card information")
    public void compareAllCardInformation(List<String> information) {
        if (!oriData.getFlagFailed().equals(true)) {
            for (String info : information) {
                switch (info) {
                    case "cardName":
                        assertThat("card name not match", yugipediaData.getCardName(), equalTo(oriData.getCardName()));
                        break;
                    case "attribute":
                        assertThat("attribute not match", yugipediaData.getAttribute(), equalTo(oriData.getAttribute()));
                        break;
                    case "rank/level":
                        assertThat("rank / level not match", yugipediaData.getRank(), equalTo(oriData.getRank()));
                        break;
                    case "monsterType":
                        assertThat("monster type not match", yugipediaData.getMonsterType(), equalTo(oriData.getMonsterType()));
                        break;
                    case "cardType":
                        System.out.println(oriData.getPendulumEffects());
                        assertThat("card type not match", yugipediaData.getCardType(), equalTo(oriData.getCardType().substring(5)));
                        if (yugipediaData.getCardType().equalsIgnoreCase("pendulum")) {
                            assertThat("pendulum effect not match", yugipediaData.getPendulumEffects(), equalTo(oriData.getPendulumEffects()));
                        }
                        break;
                    case "atk":
                        assertThat("atk not match", yugipediaData.getAtk(), equalTo(oriData.getAtk()));
                        break;
                    case "def":
                        assertThat("def not match", yugipediaData.getDef(), equalTo(oriData.getDef()));
                        break;
                    default:
                        assertThat("card effects not match", yugipediaData.getCardEffects(), equalTo(oriData.getCardEffects()));
                }
            }
        }else
            System.out.println("illegal card");
    }
}
