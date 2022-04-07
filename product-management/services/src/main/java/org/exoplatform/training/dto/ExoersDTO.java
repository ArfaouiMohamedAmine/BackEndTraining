package org.exoplatform.training.dto;

import org.json.JSONException;
import org.json.JSONObject;


public class ExoersDTO {

        private Long id;
        private String name;
        private String functionn;
        private String dateOfBirth;
        public ExoersDTO() {}
        public ExoersDTO(String name, String functionn, String dateOfBirth) {
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
    public JSONObject toJSONObject (){

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", id);
            jsonObject.put("name", name);
            jsonObject.put("functionn", functionn);
            jsonObject.put("dateOfBirth", dateOfBirth);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
