package io.swagger.petstore.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.petstore.PetId;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class PetStoreDao {

    PetId getPetId() {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://petstore.swagger.io/v2/pet/1");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();

        PetId petId = null;
        try {
            petId = mapper.readValue(response, PetId.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return petId;
    }
}
