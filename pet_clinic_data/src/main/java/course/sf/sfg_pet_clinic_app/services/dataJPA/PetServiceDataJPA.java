package course.sf.sfg_pet_clinic_app.services.dataJPA;

import course.sf.sfg_pet_clinic_app.model.Pet;
import course.sf.sfg_pet_clinic_app.repositories.PetRepository;
import course.sf.sfg_pet_clinic_app.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dataJpa")
public class PetServiceDataJPA extends AbstractServiceDataJPA<Pet, PetRepository> implements PetService {

    private final PetRepository petRepository;

    public PetServiceDataJPA(PetRepository repository) {
        super(repository);
        this.petRepository = repository;
    }
}
