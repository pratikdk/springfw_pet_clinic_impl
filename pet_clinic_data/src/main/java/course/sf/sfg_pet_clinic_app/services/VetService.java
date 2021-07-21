package course.sf.sfg_pet_clinic_app.services;

import course.sf.sfg_pet_clinic_app.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findByLastName(String lastName);
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
