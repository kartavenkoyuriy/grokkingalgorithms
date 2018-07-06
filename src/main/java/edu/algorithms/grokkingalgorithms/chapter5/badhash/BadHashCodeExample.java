package edu.algorithms.grokkingalgorithms.chapter5.badhash;

import java.util.HashMap;
import java.util.Objects;

class Person {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals for " + age + "." + name
                + " comparing to " + ((Person) o).getAge() + "." + ((Person) o).getName());

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        System.out.println("hash for " + age + "." + name);
        return age;
    }

    @Override
    public String toString() {
        return age + " - " + name;
    }
}

public class BadHashCodeExample {

    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();

        Person p1 = new Person(1, "ABC");
        Person p2 = new Person(2, "DEF");
        Person p3 = new Person(1, "XYZ");
        Person p4 = new Person(1, "PQS");
        Person p5 = new Person(1, "PQR");

        System.out.println("Adding Entries ....");
        map.put(p1, "ONE");
        map.put(p2, "TWO");
        map.put(p3, "THREE");
        map.put(p4, "FOUR");
        map.put(p5, "FIVE");
        System.out.println("\nComplete Map entries \n" + map);

        System.out.println("\nAccessing non-collided key");
        System.out.println("Value = " + map.get(p2));
        System.out.println("\nAccessing collided key");
        System.out.println("Value = " + map.get(p1));
        System.out.println("Value = " + map.get(p3));
        System.out.println("Value = " + map.get(p4));
        System.out.println("Value = " + map.get(p5));
    }
}
