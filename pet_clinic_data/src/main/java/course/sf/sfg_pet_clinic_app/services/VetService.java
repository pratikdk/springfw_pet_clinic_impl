package course.sf.sfg_pet_clinic_app.services;

import course.sf.sfg_pet_clinic_app.model.Vet;

public interface VetService extends CrudService<Vet, Long> {
    Vet findByLastName(String lastName);
}
