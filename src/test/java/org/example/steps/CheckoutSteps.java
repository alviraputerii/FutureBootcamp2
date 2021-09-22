package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.example.app.common.CommonAction;
import org.example.app.data.BliBliProductData;
import org.example.app.pages.BliBliHomePage;
import org.example.app.pages.BliBliProductPage;

public class CheckoutSteps {

    BliBliHomePage bliBliHomePage;
    BliBliProductPage bliBliProductPage;
    CommonAction commonAction;
    BliBliProductData bliBliProductData = new BliBliProductData();

    @Given("open blibli.com home page")
    public void openBlibliComHomePage() {
        bliBliHomePage.openBlibliHomePage();
    }

    @Given("blibli.com home page should be opened")
    public void blibliComHomePageShouldBeOpened() {
        String url = "https://www.blibli.com/";
        assertThat("page not opened", commonAction.verifyPageIsOpened(url), equalTo(true));
    }

    @When("at blibli.com home page search for product {string}")
    public void atBlibliComHomePageSearchForProductIndomie(String value) {
        bliBliHomePage.inputSearchValue(value);
    }

    @When("at blibli.com product page get first product name")
    public void atBlibliComProductPageGetFirstProductName() {
        bliBliProductData.setProductName(bliBliProductPage.getProductNameDisplay());
    }

    @When("at blibli.com product page get product price")
    public void atBlibliComProductPageGetProductPrice() {
        bliBliProductData.setProductPrice(bliBliProductPage.getProductPriceDisplay());
    }

    @When("at blibli.com product page hover the first product")
    public void atBlibliComProductPageHoverTheFirstProduct() {
        bliBliProductPage.hoverProduct();
    }

    @When("at blibli.com product page first product dropdown click tambah ke bag")
    public void atBlibliComProductPageFirstProductDropdownClickTambahKeBag() {
        bliBliProductPage.clickButtonTambahKeBag();
    }

    @When("at blibli.com product page modal click tambah ke bag")
    public void atBlibliComProductPageModalClickTambahKeBag() {
        bliBliProductPage.clickModalButtonTambahKeBag();
    }

    @Then("at blibli.com product page hover bag icon")
    public void atBlibliComProductPageHoverBagIcon() {
        bliBliProductPage.hoverBag();
    }

    @Then("product should be added to bag")
    public void productShouldBeAddedToBag() {
        assertThat("product not added", bliBliProductPage.getAmountItemInBag(), not(containsString("0")));
    }

    @Then("check product name that added to bag")
    public void checkProductNameThatAddedToBag() {
        assertThat("product not added", bliBliProductData.getProductName(), equalTo(bliBliProductPage.getProductNameInBag()));
    }

    @Then("check product price that added to bag")
    public void checkProductPriceThatAddedToBag() {
        assertThat("product not added", bliBliProductData.getProductPrice(), containsString(bliBliProductPage.getProductPriceInBag()));
    }

    @When("at blibli.com product page click button category")
    public void atBlibliComProductPageClickButtonCategory() {
        bliBliProductPage.clickButtonCategory();
    }

    @When("at blibli.com product page category dropdown hover bliblimart")
    public void atBlibliComProductPageCategoryDropdownHoverBliblimart() {
        bliBliProductPage.hoverMenuItemBlimart();
    }

    @When("at blibli.com product page bliblimart dropdown click kuliner jepang")
    public void atBlibliComProductPageBliblimartDropdownClickKulinerJepang() {
        bliBliProductPage.clickMenuItemKulinerJepang();
    }
}
