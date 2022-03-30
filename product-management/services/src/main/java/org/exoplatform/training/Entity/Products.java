package org.exoplatform.training.Entity;

import org.exoplatform.commons.api.persistence.ExoEntity;

import javax.persistence.*;


@ExoEntity
@Entity
@Table(name = "Products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="img")
    private String img;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private Float price;

    public Products(){}

    public Products(String name ,  String description ,   String img  , Float price ){
        this.name = name ; 
        this.img = img ;
        this.description = description; 
        this.price = price ; 
    }
    public Products(Long id , String name ,  String description ,   String img  , Float price ){
        this.id = id ; 
        this.name = name ; 
        this.img = img ;
        this.description = description; 
        this.price = price ; 
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return  this.name  ; 
     }
    }
