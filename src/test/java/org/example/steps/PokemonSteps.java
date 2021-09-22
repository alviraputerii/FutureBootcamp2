package org.example.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.example.service.PokeApiController;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PokemonSteps {
    PokeApiController pokeApiController = new PokeApiController();
    Response response;

    @When("send request for pokemon {string} in PokeApi")
    public void sendRequestForPokemonInPokeApi(String pokemon) {
        response = pokeApiController.getPokemon(pokemon.toLowerCase());
    }

    @Then("response code must be {int}")
    public void checkStatusCodeAndStoreDataIfPokemonExist(int code) {
        assertThat("Wrong response code", response.getStatusCode(), equalTo(code));
    }
}
