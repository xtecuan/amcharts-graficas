package sv.com.equifax.nivel.endeudamiento.graficas.utils;

import com.google.gson.Gson;

public class JsonUtils {



    private JsonUtils(){
    }

    public static String toJson(Object value) {
        return new Gson().toJson(value);
    }
}
