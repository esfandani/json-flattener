package com.esfandani.jsonFlattener;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.*;

public class JsonFlattener {
    private static Gson gson = new Gson();

    public static Map<String,String> flatten(String json){
        if(json == null || json.trim().equals("")){
            return Collections.emptyMap();
        }
        return flattenUtils(json);

    }
   
    private static Map<String,String> flattenUtils(String json){
        Map<String,String> map = new HashMap<String,String>();
        JsonElement root = gson.fromJson(json,JsonElement.class);
        Deque<JsonElement> stack = new ArrayDeque<JsonElement>();
        Deque<String> pathStack = new ArrayDeque<String>();
        map.put("root",json);
        stack.add(root);
        pathStack.add("");

        while(!stack.isEmpty()){
            JsonElement element = stack.pop();
            String path = pathStack.pop();
            if(element.isJsonNull()){
                map.put(path,null);
                continue;
            }
            if(element.isJsonPrimitive()){
                map.put(path,element.getAsString());
                continue;
            }
            if(element.isJsonObject()){
                JsonObject jo = element.getAsJsonObject();
                for(Map.Entry<String, JsonElement> entry: jo.entrySet()){
                    String p = getPath(path,entry.getKey());
                    JsonElement child = entry.getValue();
                    stack.push(child);
                    pathStack.push(p);
                }
                continue;
            }
            if(element.isJsonArray()){
                JsonArray ja = element.getAsJsonArray();
                Iterator<JsonElement> iter = ja.iterator();
                int counter = 0;
                while(iter.hasNext()){
                    JsonElement child = iter.next();
                    String p =path+"["+counter+"]";
                    stack.push(child);
                    pathStack.push(p);
                    counter++;
                }
            }
        }
        return map;

    }
    private static void flattenUtilsRecursive(Map<String,String> accumulator, JsonElement element,String currentPath){
        if(element == null){
            return;
        }
        if(element.isJsonNull()){
            accumulator.put(currentPath,null);
            return;
        }
        if(element.isJsonPrimitive()){
           accumulator.put(currentPath,element.getAsString());
           return;
        }
        if(element.isJsonObject()){
            JsonObject jo = element.getAsJsonObject();
            for(Map.Entry<String, JsonElement> entry: jo.entrySet()){
                String path = getPath(currentPath,entry.getKey());
                JsonElement child = entry.getValue();
                flattenUtilsRecursive(accumulator,child,path);
            }
            return;
        }
        if(element.isJsonArray()){
            JsonArray ja = element.getAsJsonArray();
            Iterator<JsonElement> iter = ja.iterator();
            int counter = 0;
            while(iter.hasNext()){
                JsonElement je = iter.next();
                flattenUtilsRecursive(accumulator,je,currentPath+"["+counter+"]");
                counter++;
            }
        }
    }
    private static String getPath(String root, String name){
        if(root.equals("")){
            return name;
        }
        return root+"."+name;
    }
}
