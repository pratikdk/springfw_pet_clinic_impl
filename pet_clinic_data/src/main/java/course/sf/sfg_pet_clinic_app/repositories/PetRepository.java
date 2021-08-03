package course.sf.sfg_pet_clinic_app.repositories;

import course.sf.sfg_pet_clinic_app.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
