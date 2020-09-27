package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnerTest {
    Owner owner;

    @BeforeEach
    public void setUp(){
        owner=new Owner();
    }

    @Test
    public void getAddress() {
        String adresse= new String("28 rue de Mexico, Maisons Laffittes");
        owner.setAddress(adresse);
        assertEquals(adresse,owner.getAddress());
    }
}