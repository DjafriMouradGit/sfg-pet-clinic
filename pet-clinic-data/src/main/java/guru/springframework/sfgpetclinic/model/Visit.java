package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
//import org.springframework.samples.petclinic.model.BaseEntity;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDate date;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Visit() {
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPetId() {
        return pet;
    }

    public void setPetId(Pet petId) {
        this.pet = pet;
    }
}

