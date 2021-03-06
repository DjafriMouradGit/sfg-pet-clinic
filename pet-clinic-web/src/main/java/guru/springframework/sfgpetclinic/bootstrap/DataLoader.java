package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialitiesService specialitiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        LoadData();
    }

    private void LoadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialitiesService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialitiesService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialitiesService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michel");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickel");
        owner1.setCity("Miami");
        owner1.setTelephone("0753902434");
        Owner.builder().address("ASDF").city("Cherchell").telephone("0753625412").build();

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("28 rue de mexico");
        owner2.setCity("Lyon");
        owner2.setTelephone("0753902434");

        Visit catVisit=new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Snizzy Kitty");
        visitService.save(catVisit);

        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Just Cat");
        fionasCat.getVisits().add(catVisit);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Loaded owners ...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Yas");
        vet2.setLastName("Bob");
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Loaded vets ...");
    }
}
