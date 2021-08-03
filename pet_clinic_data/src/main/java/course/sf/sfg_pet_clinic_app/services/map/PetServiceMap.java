package course.sf.sfg_pet_clinic_app.services.map;

import course.sf.sfg_pet_clinic_app.model.Pet;
import course.sf.sfg_pet_clinic_app.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

}
