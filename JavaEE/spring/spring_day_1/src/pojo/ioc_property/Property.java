package pojo.ioc_property;

import pojo.people_factory.People;

import java.util.*;

public class Property {
    private int id;
    private String name;
    private Set<String> sets;
    private People people;
    private List<String> words;
    private String[] strings;
    private Map<String,String> map;
    private Properties demo;
    private Desk desk;

    public Desk getDesk() {
        return desk;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public Properties getDemo() {
        return demo;
    }

    public void setDemo(Properties demo) {
        this.demo = demo;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public Property() {
    }

    public Property(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("property Set id is called");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("property Set name is called");
        this.name = name;
    }

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sets=" + sets +
                ", people=" + people +
                ", words=" + words +
                ", strings=" + Arrays.toString(strings) +
                ", map=" + map +
                ", demo=" + demo +
                ", desk=" + desk +
                '}';
    }
}
