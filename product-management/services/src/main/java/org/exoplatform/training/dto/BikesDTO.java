package org.exoplatform.training.dto;

import org.json.JSONException;
import org.json.JSONObject;

public class BikesDTO {

    private Long id;
    private String circulationNmber;
    private String color;
    private String engineSize;
    private String img;
    private String bikeDesc;

    public BikesDTO() {
    }

    public BikesDTO(String circulationNmber, String color, String engineSize, String img, String bikeDesc) {
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

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
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

    public JSONObject toJSONObject (){

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", id);
            jsonObject.put("circulationNmber", circulationNmber);
            jsonObject.put("color", color);
            jsonObject.put("engineSize", engineSize);
            jsonObject.put("img", img);
            jsonObject.put("bikeDesc", bikeDesc);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
