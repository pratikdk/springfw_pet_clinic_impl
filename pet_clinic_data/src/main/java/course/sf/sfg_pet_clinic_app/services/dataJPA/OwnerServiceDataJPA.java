package course.sf.sfg_pet_clinic_app.services.dataJPA;

import course.sf.sfg_pet_clinic_app.model.Owner;
import course.sf.sfg_pet_clinic_app.repositories.OwnerRepository;
import course.sf.sfg_pet_clinic_app.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dataJpa")
public class OwnerServiceDataJPA extends AbstractServiceDataJPA<Owner, OwnerRepository> implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceDataJPA(OwnerRepository repository) {
        super(repository);
        this.ownerRepository = repository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
