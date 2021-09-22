package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.app.pages.WikipediaPage;
import org.hamcrest.MatcherAssert;

public class WikipediaSteps {

    WikipediaPage wikipediaPage;

    @Given("the user is on the Wikipedia home page")
    public void theUserIsOnTheWikipediaHomePage() {
        wikipediaPage.open();
    }

    @When("the user looks up the definition of the word {string}")
    public void theUserLooksUpTheDefinitionOfTheWordApple(String word) {
        wikipediaPage.inputSearchValue(word);
    }

    @Then("they should see the header of article is {string}")
    public void theyShouldSeeTheHeaderOfArticleIsApple(String header) {
        MatcherAssert.assertThat("The header name is", wikipediaPage.getHeaderResult().equalsIgnoreCase(header));
    }
}
