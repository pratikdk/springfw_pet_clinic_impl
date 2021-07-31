package course.sf.sfg_pet_clinic_app.bootstrap_data;

import course.sf.sfg_pet_clinic_app.model.Owner;
import course.sf.sfg_pet_clinic_app.model.Pet;
import course.sf.sfg_pet_clinic_app.model.PetType;
import course.sf.sfg_pet_clinic_app.model.Vet;
import course.sf.sfg_pet_clinic_app.services.OwnerService;
import course.sf.sfg_pet_clinic_app.services.PetService;
import course.sf.sfg_pet_clinic_app.services.PetTypeService;
import course.sf.sfg_pet_clinic_app.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader1 implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public DataLoader1(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

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

        petDog.setOwner(owner1);
        owner1.getPets().add(petDog);

        petCat.setOwner(owner2);
        owner2.getPets().add(petCat);

        System.out.println("Assigned Pets to Owners");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Added Owners");


        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Vet_1 FN");
        vet1.setLastName("Vet_1 LN");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Vet_2 FN");
        vet2.setLastName("Vet_2 LN");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Added Vets");
    }
}
