package course.sf.sfg_pet_clinic_app.services.dataJPA;

import course.sf.sfg_pet_clinic_app.model.PetType;
import course.sf.sfg_pet_clinic_app.repositories.PetTypeRepository;
import course.sf.sfg_pet_clinic_app.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dataJpa")
public class PetTypeServiceDataJPA extends AbstractServiceDataJPA<PetType, PetTypeRepository> implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeServiceDataJPA(PetTypeRepository petTypeRepository) {
        super(petTypeRepository);
        this.petTypeRepository = petTypeRepository;
    }
}
