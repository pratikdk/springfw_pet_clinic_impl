package course.sf.sfg_pet_clinic_app.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {
    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
