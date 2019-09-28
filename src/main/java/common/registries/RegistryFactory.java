package common.registries;

import java.util.HashMap;

public class RegistryFactory<T> {
    public HashMap<String, T> MAP = new HashMap<>();

    public void init(){}

    public void register(String name, T object){
        MAP.put( name , object);
    }

    public T getObject(String name){
        return MAP.getOrDefault(name, null);
    }
}
