package course.sf.sfg_pet_clinic_app.services.map;

import course.sf.sfg_pet_clinic_app.model.Speciality;
import course.sf.sfg_pet_clinic_app.model.Vet;
import course.sf.sfg_pet_clinic_app.services.SpecialityService;
import course.sf.sfg_pet_clinic_app.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet findByLastName(String lastName) {
        for (Vet vet: super.findAll()) {
            if (vet.getLastName().equals(lastName)) {
                return vet;
            }
        }
        return null;
    }

    @Override
    public Vet save(Vet object) {
        if (object != null) {
            if (object.getSpecialities() != null) {
                object.getSpecialities().forEach(speciality -> {
                    if (speciality.getId() == null) {
                        Speciality savedSpeciality = specialityService.save(speciality);
                        speciality.setId(savedSpeciality.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }
}
