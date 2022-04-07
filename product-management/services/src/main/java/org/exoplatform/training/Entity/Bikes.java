package org.exoplatform.training.Entity;

import org.exoplatform.commons.api.persistence.ExoEntity;

import javax.persistence.*;

@ExoEntity
@Entity
@Table(name = "Bikes")
public class Bikes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "circulationNmber")
    private String circulationNmber;

    @Column(name = "color")
    private String color;

    @Column(name = "engineSize")
    private int engineSize;

    @Column(name = "img")
    private String img;

    @Column(name = "bikeDesc")
    private String bikeDesc;

    public Bikes() {
    }

    public Bikes(Long id, String circulationNmber, String color, int engineSize, String img, String bikeDesc) {
        this.id = id;
        this.circulationNmber = circulationNmber;
        this.color = color;
        this.engineSize = engineSize;
        this.img = img;
        this.bikeDesc = bikeDesc;
    }

    public Bikes(String circulationNmber, String color, int engineSize, String img, String bikeDesc) {
        this.circulationNmber = circulationNmber;
        this.color = color;
        this.engineSize = engineSize;
        this.img = img;
        this.bikeDesc = bikeDesc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCirculationNmber() {
        return circulationNmber;
    }

    public void setCirculationNmber(String circulationNmber) {
        this.circulationNmber = circulationNmber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBikeDesc() {
        return bikeDesc;
    }

    public void setBikeDesc(String bikeDesc) {
        this.bikeDesc = bikeDesc;
    }
}
