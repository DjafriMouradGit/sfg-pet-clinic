package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;


public class OwnerSDJpaServiceTest {

    private OwnerSDJpaService ownerSDJpaService;

    @Mock
    private OwnerRepository ownerRepository;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
//        ownerSDJpaService=new OwnerSDJpaService();
    }

    @Test
    public void findAll() {
        //Given --> Définition du Mock
        //When --> Action
        Set<Owner> owners= ownerSDJpaService.findAll();
        System.out.println(owners);
        //Then --> Assert
        //assertEquals(owners.size(),0);
    }
}