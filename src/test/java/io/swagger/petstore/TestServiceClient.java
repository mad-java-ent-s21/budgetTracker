package io.swagger.petstore;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.swapi.*;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    @Test
    public void testswapiStarshipsJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://swapi.dev/api/starships/10/");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();

        Starships starships = mapper.readValue(response, Starships.class);
        assertEquals("Millennium Falcon", starships.getName());
        //assertEquals("???", response);
    }

    @Test
    public void testswapiPlanetsJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://swapi.dev/api/planets/1/");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();

        Planets planets = mapper.readValue(response, Planets.class);
        assertEquals("Tatooine", planets.getName());
    }

    @Test
    public void testswapiPetsJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://petstore.swagger.io/v2/pet/1");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();

        PetId petId = mapper.readValue(response, PetId.class);
        assertEquals("Tica", petId.getName());
        //assertEquals("???", response);
    }
}
