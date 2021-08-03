package course.sf.sfg_pet_clinic_app.services.map;

import course.sf.sfg_pet_clinic_app.model.Speciality;
import course.sf.sfg_pet_clinic_app.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {
}
