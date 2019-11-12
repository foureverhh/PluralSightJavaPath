package server_basic.web;

import java.util.HashSet;
import java.util.Set;

public class Mapping {
    private String name;
    private Set<String> urls;

    public Mapping() {
        urls = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<String> getUrls() {
        return urls;
    }

    public void addPattern(String newUrl){
        urls.add(newUrl);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name+" ");
        for(String url:urls){
            builder.append(url+" ");
        }
        return builder.toString();
    }
}
