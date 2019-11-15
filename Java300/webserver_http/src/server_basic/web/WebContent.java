package server_basic.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebContent {
    private List<Entity> entities = null;
    private List<Mapping> mappings = null;
    private Map<String,String> entityMap = new HashMap<>();
    private Map<String,String> mappingMap = new HashMap<>();
    WebContent(List<Entity> entities,List<Mapping> mappings){
        this.entities = entities;
        this.mappings = mappings;
        for(Entity entity:entities){
            entityMap.put(entity.getName(),entity.getClz());
        }
        for(Mapping mapping:mappings){
            for(String String:mapping.getUrls())
                mappingMap.put(String,mapping.getName());
        }
    }

    public String getClz(String pattern){
        String servletName = mappingMap.get(pattern);
        return entityMap.get(servletName);
    }
}
