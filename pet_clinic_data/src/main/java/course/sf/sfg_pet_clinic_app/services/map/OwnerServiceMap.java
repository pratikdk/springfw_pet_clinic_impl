package course.sf.sfg_pet_clinic_app.services.map;

import course.sf.sfg_pet_clinic_app.model.Owner;
import course.sf.sfg_pet_clinic_app.model.Pet;
import course.sf.sfg_pet_clinic_app.services.OwnerService;
import course.sf.sfg_pet_clinic_app.services.PetService;
import course.sf.sfg_pet_clinic_app.services.PetTypeService;
import org.springframework.stereotype.Service;


@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        for (Owner owner: super.findAll()) {
            if (owner.getLastName().equals(lastName)) {
                return owner;
            }
        }
       return null;
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet != null) {
                        if (pet.getPetType() != null) {
                            if (pet.getPetType().getId() == null) { // not in db
                                pet.setPetType(petTypeService.save(pet.getPetType()));
                            }
                        } else {
                            throw new RuntimeException("PetType can't be null");
                        }

                        if (pet.getId() == null) {
                            Pet savedPet = petService.save(pet);
                            pet.setId(savedPet.getId());
                        }
                    } else {
                        throw new NullPointerException("Pet Object can't be null");
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

}
