package org.example.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.app.common.CommonAction;
import org.example.app.pages.SeleniumEasyPage;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FormSteps {

    SeleniumEasyPage seleniumEasyPage;
    CommonAction commonAction;

    @Given("user open form")
    public void userOpenForm() {
        seleniumEasyPage.openSeleniumEasyHomePage();
    }

    @Then("validate url")
    public void validateUrl() {
        String url = "https://www.seleniumeasy.com/test/input-form-demo.html";
        assertThat("invalid URL", commonAction.verifyPageIsOpened(url), equalTo(true));
    }

    @When("user fill the form with following data")
    public void userFillTheFormWithFollowingData(DataTable formDataTable) {
        Map<String,Object> formData = formDataTable.asMap(String.class, Object.class);
        seleniumEasyPage.typeFirstName(formData.get("firstName").toString());
        seleniumEasyPage.typeLastName(formData.get("lastName").toString());
        seleniumEasyPage.typeEmail(formData.get("email").toString());
    }
}
