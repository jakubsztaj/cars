package pl.carwebapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    public Stats() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
