package _11_stack_queue.exercises;

import java.util.*;

public class DemergingUseQueue {

    public static void main(String[] args) {
        Person o1 = new Person("a", "nu", 10);
        Person o2 = new Person("b", "nam", 11);
        Person o3 = new Person("c", "nu", 12);
        Person o4 = new Person("d", "nam", 13);
        Person o5 = new Person("e", "nam", 14);
        Person o6 = new Person("f", "nu", 15);
        Queue<Person> qFemale = new LinkedList<>();
        Queue<Person> qMale = new LinkedList<>();
        ArrayList<Person> ar = new ArrayList<>();
        ar.add(o1);
        ar.add(o2);
        ar.add(o3);
        ar.add(o4);
        ar.add(o5);
        ar.add(o6);

        ar.forEach(o -> {
                    if (o.getGender() == "nu")
                        qFemale.add(o);
                    else
                        qMale.add(o);
                }
        );

        ar.clear();
        while (!qFemale.isEmpty())
            ar.add(qFemale.remove());
        while (!qMale.isEmpty())
            ar.add(qMale.remove());
        System.out.println(ar);

//        Map<String, List<String>> map = new HashMap<>();
//        map.computeIfAbsent("key1", k -> new ArrayList<>()).add("value1");
//        map.computeIfAbsent("key1", k -> new ArrayList<>()).add("value2");
//        System.out.println(map.get("key1").size());
    }
}

class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private String gender;
    private int age;

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
