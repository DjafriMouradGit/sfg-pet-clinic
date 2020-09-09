package guru.springframework.sfgpetclinic.model;
import java.util.Date;

public class Pet extends BaseEntity{
     private PetTpe petTpe;
     private Owner owner;
     private Date birthDate;

    public PetTpe getPetTpe() {
        return petTpe;
    }

    public void setPetTpe(PetTpe petTpe) {
        this.petTpe = petTpe;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
