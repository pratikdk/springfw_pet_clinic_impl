package course.sf.sfg_pet_clinic_app.bootstrap_data;

import course.sf.sfg_pet_clinic_app.model.Owner;
import course.sf.sfg_pet_clinic_app.model.Vet;
import course.sf.sfg_pet_clinic_app.services.OwnerService;
import course.sf.sfg_pet_clinic_app.services.VetService;
import org.springframework.boot.CommandLineRunner;

public class DataLoader1 implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader1(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Owner_1 FN");
        owner1.setLastName("Owner_1 LN");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Owner_2 FN");
        owner2.setLastName("Owner_2 LN");

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
