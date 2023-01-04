package iex;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.Ensure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.rest.SerenityRest.when;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class starWarsCharacters {
    @Test
    public void request_should_succeed_for_listed_characters(){
        when().get("https://swapi.dev/api/people/1")
                .then().statusCode(200);



    }
    /*
    @Test
    public void should_return_character_name_and_height(){
        SerenityRest.when().get("https://swapi.dev/api/people/1")
                .then().body("name", Matchers.equalTo("Luke Skywalker"))
                .and().body("height", Matchers.equalTo("172"));

    }
    Above is the same as the following except we have imported the public static methods
    when() & equalTo()
    */

    /*
    @Test
    public void should_return_character_name_and_height(){
        when().get("https://swapi.dev/api/people/1")
                .then().statusCode(200)
                .and().body("name", equalTo("Luke Skywalker"))
                .and().body("height", equalTo("172"));

    }
    checking reports after this will give us all the data from the request to get back what we asked for
    we can use Ensure.that as show below
    */


    /*
        all tests will use "https://swapi.dev/api/
        so we can shorten this using a method to set the base URL as follows
    */
    @Before
    public void setBaseUrl(){
        RestAssured.baseURI = "https://swapi.dev/api/";
    }
    @Test
    public void should_return_character_name_and_height(){
        when().get("people/1")
                .then().statusCode(200);

        Ensure.that("name is returned", response -> response.body("name", equalTo("Luke Skywalker")));
        Ensure.that("height is returned", response -> response.body("height", equalTo("172")));
    }



}


