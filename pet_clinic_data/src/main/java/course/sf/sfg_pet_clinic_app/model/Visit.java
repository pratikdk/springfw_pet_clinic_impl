package course.sf.sfg_pet_clinic_app.model;

import java.time.LocalDate;

public class Visit extends BaseEntity {
    private LocalDate date;
    private String description;
    private Pet pet;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
