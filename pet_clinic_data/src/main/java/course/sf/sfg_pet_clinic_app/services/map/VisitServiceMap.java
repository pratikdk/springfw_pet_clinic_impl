package course.sf.sfg_pet_clinic_app.services.map;

import course.sf.sfg_pet_clinic_app.model.Visit;
import course.sf.sfg_pet_clinic_app.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit save(Visit object) {
        if (object.getPet() == null || object.getPet().getId() == null || object.getPet().getOwner() == null || object.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit object passed to save().");
        }
        return super.save(object);
    }
}
