package course.sf.sfg_pet_clinic_app.services.map;

import course.sf.sfg_pet_clinic_app.model.Owner;
import course.sf.sfg_pet_clinic_app.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Owner findByLastName(String lastName) {
        for (Owner owner: super.findAll()) {
            if (owner.getLastName().equals(lastName)) {
                return owner;
            }
        }
       return null;
    }

}
