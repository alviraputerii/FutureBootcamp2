package org.example.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PokeApiController {
    public Response getPokemon(String pokemonName){
    return RestAssured.given().
            header("Content-Type", "application/json").
            header("Accept", "application/json").
            when().
            get("https://pokeapi.co/api/v2/pokemon/"+pokemonName);
    }
}
