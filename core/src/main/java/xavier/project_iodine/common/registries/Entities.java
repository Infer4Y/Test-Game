package xavier.project_iodine.common.registries;

import xavier.project_iodine.common.entities.Entity;
import xavier.project_iodine.utils.Logger;

import java.util.HashMap;

public class Entities {
    public static final HashMap<String, Entity> ENTITY_MAP = new HashMap<>();

    public static void init(){
    }

    private static void register(Entity entity){
        ENTITY_MAP.put(entity.getName(), entity);
        Logger.log(Logger.Type.REGISTRY, "[Registry:Entities] %s has been registered.".replace("%s", entity.getName()));
    }

    private static void register(Entity... entities){
        for (Entity entity : entities) {
            register(entity);
        }
    }
}
