package course.sf.sfg_pet_clinic_app.services.dataJPA;

import course.sf.sfg_pet_clinic_app.model.Vet;
import course.sf.sfg_pet_clinic_app.repositories.VetRepository;
import course.sf.sfg_pet_clinic_app.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dataJpa")
public class VetServiceDataJPA extends AbstractServiceDataJPA<Vet, VetRepository> implements VetService {

    private final VetRepository vetRepository;

    public VetServiceDataJPA(VetRepository vetRepository) {
        super(vetRepository);
        this.vetRepository = vetRepository;
    }

    @Override
    public Vet findByLastName(String lastName) {
        return vetRepository.findByLastName(lastName);
    }
}
