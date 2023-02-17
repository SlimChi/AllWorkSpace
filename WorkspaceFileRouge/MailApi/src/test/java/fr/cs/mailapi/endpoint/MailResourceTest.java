package fr.cs.mailapi.endpoint;

import fr.cs.mailapi.metier.InfoEmail;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

class MailResourceTest {

    @Test
    void sendMail() {

        InfoEmail infoEmail = new InfoEmail("slimane.chihati@gmail.com","message","ici c'est le body");

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .header("apikey","XXX-ABC")
                .body(infoEmail)
                .when()
                .post("/api/mail")
                .then()
                .statusCode(HttpServletResponse.SC_ACCEPTED);
    }

    @Test
    void generateApiKey() {
    }
}