package course.sf.sfg_pet_clinic_app.services.dataJPA;

import course.sf.sfg_pet_clinic_app.model.Speciality;
import course.sf.sfg_pet_clinic_app.repositories.SpecialityRepository;
import course.sf.sfg_pet_clinic_app.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dataJpa")
public class SpecialityServiceDataJPA extends AbstractServiceDataJPA<Speciality, SpecialityRepository> implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialityServiceDataJPA(SpecialityRepository specialityRepository) {
        super(specialityRepository);
        this.specialityRepository = specialityRepository;
    }
}
