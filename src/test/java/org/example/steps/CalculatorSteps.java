package org.example.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;
import org.example.app.pages.CalculatorPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CalculatorSteps extends ScenarioSteps {

    CalculatorPage calculatorPage;

    @When("I press number from {int} to {int}")
    public void iPressNumberFromTo(int from, int to) {
        for (int i = from; i >= to ; i--) {
            calculatorPage.clickNumber(i);
        }
    }

    @Then("I could see all number from {int} to {int} appear on the formula screen")
    public void iCouldSeeAllNumberFromToAppearOnTheFormulaScreen(int from, int to) {
        String numbers = "";
        for (int i = from; i >= to ; i--) {
            numbers = numbers.concat(String.valueOf(i));
        }
        assertThat(calculatorPage.getFormulaText(), equalTo(numbers));
    }
}
