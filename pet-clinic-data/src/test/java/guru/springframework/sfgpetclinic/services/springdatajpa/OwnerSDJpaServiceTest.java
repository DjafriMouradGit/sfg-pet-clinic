package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    // Pour définir le mock, soit en utilise Mockito.mock() sinon on utilise l'annotation @Mock
    // @Spy. La différence entre Mock et Spy : la deuxième permet d’instancier l’objet mocké,
    // ce qui peut être très utile quand nous souhaitons mocker une classe et non pas une interface.

    OwnerRepository ownerRepository = Mockito.mock(OwnerRepository.class);
    @Mock
    PetTypeRepository petTypeRepository;
    @Mock
    PetRepository petRepository;
//     Pour injecter une ressource soit InjectMocks soit dans setUp avec new
    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    // Variables and Objects
    public static final String LAST_NAME = "Smith";
    Owner returnOwner;

    @BeforeEach
    void setUp() {
//        ownerSDJpaService=new OwnerSDJpaService(ownerRepository,petTypeRepository,petRepository);
        returnOwner = Owner.builder().id(1l).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        //Given
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        //When
        Owner smith = ownerSDJpaService.findByLastName(LAST_NAME);
        //Then
        assertNotNull(smith);
        assertEquals(LAST_NAME, smith.getLastName());
        // @Verify permet de vérifier qu’une méthode a été bien appelée
        // et que que les interactions avec le mock sont celles attendues.
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        //Given
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(Owner.builder().id(1L).build());
        returnOwnerSet.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);
        //When
        Set<Owner> owners = ownerSDJpaService.findAll();
        //Then
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        //Given
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        //When
        Owner owner = ownerSDJpaService.findById(1l);
        //Then
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        //Given
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        //When
        Owner owner = ownerSDJpaService.findById(1l);
        //Then
        assertNull(owner);
    }

    @Test
    void save() {
        //Given
        Owner ownerToSave = Owner.builder().id(1l).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        //When
        Owner savedOwner = ownerSDJpaService.save(ownerToSave);
        //Then
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnOwner);
        // default is 1 times
        // nombre total de fois ou la méthode a été appelée
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1l);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}