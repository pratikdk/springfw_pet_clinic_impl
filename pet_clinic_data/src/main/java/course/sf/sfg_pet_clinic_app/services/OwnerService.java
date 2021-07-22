package course.sf.sfg_pet_clinic_app.services;

import course.sf.sfg_pet_clinic_app.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
