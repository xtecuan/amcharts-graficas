package sv.com.equifax.nivel.endeudamiento.graficas.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {


    private static Gson gson;

    public static Gson getGson(){
        
        if(gson==null){
            gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        }
        return gson;
    }


    private JsonUtils(){
    }

    public static String toJson(Object value) {
        return getGson().toJson(value);
    }
}
