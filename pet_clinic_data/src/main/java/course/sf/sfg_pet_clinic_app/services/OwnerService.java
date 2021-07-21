package course.sf.sfg_pet_clinic_app.services;

import course.sf.sfg_pet_clinic_app.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
