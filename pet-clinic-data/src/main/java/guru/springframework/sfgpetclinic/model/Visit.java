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
    @Column(name = "pet_id")
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet petId;

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

    public Integer getPetId() {
        return this.petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

}

