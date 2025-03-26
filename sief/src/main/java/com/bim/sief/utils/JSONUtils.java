package com.bim.sief.utils;

import com.google.gson.Gson;
import lombok.Data;

@Data
public class JSONUtils {



    static public String responseGeneratorJSON(Boolean admin, String msg, String JWT, String role) {
        Response response = new Response();
        response.setAdmin(admin);
        response.setMsg(msg);
        response.setJWT(JWT);
        response.setRole(role);
        Gson gson = new Gson();
        return gson.toJson(response);
    }

    static public String covertObjectToJSON(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }
}

@Data
class Response {
    private Boolean admin = false;
    private String msg = "";
    private String JWT = "";
    private String role ="";
}