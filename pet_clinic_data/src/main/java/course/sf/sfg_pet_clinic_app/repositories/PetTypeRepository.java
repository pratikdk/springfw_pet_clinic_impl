package course.sf.sfg_pet_clinic_app.repositories;

import course.sf.sfg_pet_clinic_app.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
