package org.exoplatform.training.dto;

import org.json.JSONException;
import org.json.JSONObject;

public class ProductDTO
{
    private Long id;
    private String name;
    private Float price;
    private String img;
    private String description;

    public ProductDTO(){}

    public ProductDTO(String name , Float price ,  String img , String description)
    {
        this.name = name ; 
        this.price = price ; 
        this.img = img ; 
        this.description = description ; 
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

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public JSONObject toJSONObject (){

        JSONObject jsonObject = new JSONObject();
              try {
                jsonObject.put("id", id);
                jsonObject.put("name", name);
                jsonObject.put("img", img);
                jsonObject.put("description", description);
                jsonObject.put("price", price);
            } catch (JSONException e) {
                e.printStackTrace();
            }
      return jsonObject;
  }
}
