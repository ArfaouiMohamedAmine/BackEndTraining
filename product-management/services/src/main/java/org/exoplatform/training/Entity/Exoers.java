package org.exoplatform.training.Entity;

import org.exoplatform.commons.api.persistence.ExoEntity;

import javax.persistence.*;
import java.util.Date;

@ExoEntity
@Entity
@Table(name = "Exoers")
public class Exoers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "finction")
    private String function;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    public Exoers() {}

    public Exoers(Long id, String name, String function, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.function = function;
        this.dateOfBirth = dateOfBirth;
    }

    public Exoers(String name, String function, Date dateOfBirth) {
        this.name = name;
        this.function = function;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
