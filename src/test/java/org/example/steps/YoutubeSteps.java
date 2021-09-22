package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;
import org.example.app.data.YoutubeData;
import org.example.app.pages.YoutubePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class YoutubeSteps extends ScenarioSteps {

    YoutubePage youtubePage;
    YoutubeData youtubeData = new YoutubeData();

    @Given("user search for {string}")
    public void searchForBlibli(String value) {
        youtubePage.inputSearchValue(value);
    }

    @When("user click Blibli channel")
    public void userClickBlibliChannel() {
        youtubePage.clickBlibliChannel();
    }

    @And("user go to about tab")
    public void userGoToAboutTab() {
        youtubePage.swipeToAboutTab();
    }

    @Then("get channel description")
    public void userGetChannelDescription() {
        youtubePage.getDescriptionText();
    }

    @When("user go to playlist tab")
    public void userGoToPlaylistTab() {
        youtubePage.swipeToPlaylistTab();
    }

    @And("user open playlist {string}")
    public void userGetPlaylistBlibliThAnniversarry(String value) {
        youtubePage.clickPlaylist(value);
    }

    @And("get fist video title")
    public void getFistVideoTitle() {
        youtubeData.setVideoTitle(youtubePage.getVideoTitle());
    }

    @And("user click the first video")
    public void userClickTheFirstVideo() {
        youtubePage.clickFirstVideo();
    }

    @Then("validate that the top video clicked is the one being play")
    public void validateThatTheTopVideoClickedIsTheOneBeingPlay() {
        youtubePage.swipePlaylist();
        assertThat("video title not match", youtubeData.getVideoTitle(), equalTo(youtubePage.getVideoTitle()));
    }


}
