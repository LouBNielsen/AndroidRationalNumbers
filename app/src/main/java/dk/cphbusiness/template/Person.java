package dk.cphbusiness.template;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private List<Pet> pets = new ArrayList();

    public Person(String name) {
        this.name = name;
        }

    public String getName() { return name; }

    public void setName(String value) { name = value; }

    public List<Pet> getPets() { return pets; }

    }
