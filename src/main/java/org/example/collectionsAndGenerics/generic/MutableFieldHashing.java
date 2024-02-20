package org.example.collectionsAndGenerics.generic;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Deer {
    private String name;

    public Deer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Deer{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deer deer = (Deer) o;
        return Objects.equals(name, deer.name);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 85 * (hash + name.length());
        return hash;
    }
}

public class MutableFieldHashing {
    public static void main(String[] args) {
        Deer deer = new Deer("donny");
        Map<Deer,String> deerStringMap = new HashMap<>();
        deerStringMap.put(deer,"general");
        System.out.println(deer);
        System.out.println(deer.hashCode() + " : " + deerStringMap.containsKey(deer));
        System.out.println(deerStringMap);
        System.out.println("--------------------------------");
        deer.setName("frey");
        System.out.println(deer);
         System.out.println(deer.hashCode() + " : " + deerStringMap.containsKey(deer));
         System.out.println(deerStringMap);
    }
}
