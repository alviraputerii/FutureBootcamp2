package org.example.app.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.example.app.utils.Utility;

public class YoutubePage extends Utility {

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Search']")
    WebElementFacade buttonSearch;

    @FindBy(id = "search_edit_text")
    WebElementFacade inputSearch;

    @FindBy(id = "text")
    WebElementFacade searchResult;

    @FindBy(id = "channel_avatar")
    WebElementFacade channelBlibli;

    @FindBy(xpath = "//android.widget.Button[@content-desc='About']")
    WebElementFacade tabAbout;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Playlists']")
    WebElementFacade tabPlaylist;

    @FindBy(xpath = "//*[@resource-id='com.google.android.youtube:id/results']/android.view.ViewGroup/android.view.ViewGroup[1]")
    WebElementFacade textDescription;

    private String playlist = "//android.view.ViewGroup[@content-desc='%s']";

    @FindBy(id = "title")
    WebElementFacade videoTitle;

    @FindBy(id = "thumbnail")
    WebElementFacade video;

    public void inputSearchValue(String value) {
        clickByWebElementFacade(buttonSearch);
        typeValueWithoutEnterByWebElementFacade(inputSearch, value);
        clickByWebElementFacade(searchResult);
    }

    public void clickBlibliChannel() {
        clickByWebElementFacade(channelBlibli);
    }

    public void swipeToAboutTab() {
        swipe(870, 310, 200, 310, 0);
        clickByWebElementFacade(tabAbout);
    }

    public void getDescriptionText() {
        System.out.println(getTextByWebElementFacade(textDescription));
    }

    public void swipeToPlaylistTab() {
        swipe(200, 310, 870, 310, 0);
        clickByWebElementFacade(tabPlaylist);
    }

    public void clickPlaylist(String value) {
        clickByXpath(String.format(playlist, value));
        System.out.println(String.format(playlist, value));
    }

    public String getVideoTitle() {
        System.out.println(getTextByWebElementFacade(videoTitle));
        return getTextByWebElementFacade(videoTitle);
    }

    public void clickFirstVideo() {
       clickByWebElementFacade(video);
    }

    public void swipePlaylist() {
        waitABit(1000);
        swipe(560, 900, 560, 1900, 0);
    }
}