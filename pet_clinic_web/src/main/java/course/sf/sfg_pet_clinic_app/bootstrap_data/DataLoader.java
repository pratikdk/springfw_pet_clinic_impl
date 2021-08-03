package course.sf.sfg_pet_clinic_app.bootstrap_data;

import course.sf.sfg_pet_clinic_app.model.*;
import course.sf.sfg_pet_clinic_app.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, PetService petService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    public void loadData() {
        PetType dogPetType = new PetType();
        dogPetType.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dogPetType);

        PetType catPetType = new PetType();
        catPetType.setName("Cat");
        PetType savedCatPetType = petTypeService.save(catPetType);

        System.out.println("Added Pet Types");


        Pet petDog = new Pet();
        petDog.setName("Pet_Dog");
        petDog.setBirthDate(LocalDate.now());
        petDog.setPetType(dogPetType);
        Pet savedPetDog = petService.save(petDog);

        Pet petCat = new Pet();
        petCat.setName("Pet_Cat");
        petCat.setBirthDate(LocalDate.now());
        petCat.setPetType(catPetType);
        Pet savedPetCat = petService.save(petCat);

        System.out.println("Added Pets");


        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Owner_1 FN");
        owner1.setLastName("Owner_1 LN");
        owner1.setAddress("Owner_1 Address");
        owner1.setCity("Owner_1 City");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Owner_2 FN");
        owner2.setLastName("Owner_2 LN");
        owner2.setAddress("Owner_2 Address");
        owner2.setCity("Owner_2 City");

        petDog.setOwner(owner1); // Cascade.all(owner->pet) updates pet entity
        owner1.getPets().add(petDog);

        petCat.setOwner(owner2);
        owner2.getPets().add(petCat);

        System.out.println("Assigned Pets to Owners");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Added Owners");


        Speciality specialityA = new Speciality();
        specialityA.setDescription("specialityA");

        Speciality specialityB = new Speciality();
        specialityB.setDescription("specialityB");

        Speciality specialityC = new Speciality();
        specialityC.setDescription("specialityC");

        specialityService.save(specialityA);
        specialityService.save(specialityB);
        specialityService.save(specialityC);

        System.out.println("Saved Specialities");


        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Vet_1 FN");
        vet1.setLastName("Vet_1 LN");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Vet_2 FN");
        vet2.setLastName("Vet_2 LN");

        vet1.getSpecialities().add(specialityA);
        vet2.getSpecialities().add(specialityB);
        vet2.getSpecialities().add(specialityC);

        System.out.println("Added specialities to Vets");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Added Vets");


        Visit catVisit = new Visit();
        catVisit.setPet(savedPetCat);
        catVisit.setDescription("Sneezy Cat");
        catVisit.setDate(LocalDate.now());

        visitService.save(catVisit);
    }
}
