package course.sf.sfg_pet_clinic_app.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Speciality extends BaseEntity{
    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
