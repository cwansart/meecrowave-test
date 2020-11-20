package de.cwansart.meecrowave.application;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.meecrowave.Meecrowave;
import org.apache.meecrowave.junit5.MeecrowaveConfig;
import org.apache.meecrowave.testing.ConfigurationInject;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

@MeecrowaveConfig
public class HelloResourceTest {

    @ConfigurationInject
    private Meecrowave.Builder config;

    private String getUrl() {
        return String.format("http://localhost:%s/hello", this.config.getHttpPort());
    }

    @Test
    public void testNames() {
        RestAssured.get(this.getUrl())
                .then()
                .contentType(ContentType.JSON)
                .body(".", Matchers.hasSize(6))
                .body(".", Matchers.hasItems(
                        "Hello",
                        "Hallo",
                        "こんにちは",
                        "Hallå",
                        "Здравствуйте",
                        "Hola"
                ));
    }
}
