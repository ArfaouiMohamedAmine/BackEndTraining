package org.exoplatform.training.Entity;

import org.exoplatform.commons.api.persistence.ExoEntity;

import javax.persistence.*;

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

    @Column(name = "functionn")
    private String functionn;

    @Column(name = "dateOfBirth")
    private String dateOfBirth;

    public Exoers() {}

    public Exoers(Long id, String name, String functionn, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.functionn = functionn;
        this.dateOfBirth = dateOfBirth;
    }

    public Exoers(String name, String functionn, String dateOfBirth) {
        this.name = name;
        this.functionn = functionn;
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

    public String getFunctionn() {
        return functionn;
    }

    public void setFunctionn(String functionn) {
        this.functionn = functionn;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
