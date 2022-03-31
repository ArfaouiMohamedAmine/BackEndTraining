package org.exoplatform.training.dto;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class ExoersDTO {

        private Long id;
        private String name;
        private String function;
        private Date dateOfBirth;
        public ExoersDTO() {}
        public ExoersDTO(String name, String function, Date dateOfBirth) {
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
    public JSONObject toJSONObject (){

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", id);
            jsonObject.put("name", name);
            jsonObject.put("function", function);
            jsonObject.put("dateOfBirth", dateOfBirth);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
