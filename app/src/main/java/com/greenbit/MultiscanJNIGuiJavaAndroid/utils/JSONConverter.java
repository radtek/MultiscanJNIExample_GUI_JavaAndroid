package com.greenbit.MultiscanJNIGuiJavaAndroid.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.List;

public class JSONConverter {

    public static JSONObject toJSON(Object object) throws JSONException, IllegalAccessException {
        String str = "";
        Class c = object.getClass();
        JSONObject jsonObject = new JSONObject();
        for (Field field : c.getDeclaredFields()) {
            field.setAccessible(true);
            String name = "\"" + field.getName() + "\"";
            String value = "\"" + field.get(object) + "\"";
            jsonObject.put(name, value);
        }
        System.out.println(jsonObject.toString());
        return jsonObject;
    }


    public static String toJSON(List list) throws JSONException, IllegalAccessException {
        JSONArray jsonArray = new JSONArray();
        for (Object i : list) {
            String jstr = toJSON(i).toString();
            JSONObject jsonObject = new JSONObject(jstr);
            jsonArray.put(jsonArray);
        }
        return jsonArray.toString();
    }
}