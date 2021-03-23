package io.swagger.petstore.persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetStoreDaoTest {

    @Test
    void getPetIdSuccess() {
        PetStoreDao dao = new PetStoreDao();
        assertEquals("Tica", dao.getPetId());
    }
}