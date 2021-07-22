package course.sf.sfg_pet_clinic_app.services.map;

import course.sf.sfg_pet_clinic_app.model.Vet;
import course.sf.sfg_pet_clinic_app.services.VetService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
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
        return super.save(object.getId(), object);
    }
}
