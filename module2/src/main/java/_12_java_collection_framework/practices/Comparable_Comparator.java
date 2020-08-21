package _12_java_collection_framework.practices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//class AgeComparator implements Comparator<Student>{
//    @Override
//    public int compare(Student o1, Student o2) {
//        return o1.getAge()-o2.getAge();
//    }
//}
public class Comparable_Comparator  {
    public static void main(String[] args) {
        Student student = new Student("Kien", 30, "HT");
        Student student1 = new Student("Nam", 26, "HN");
        Student student2 = new Student("Anh", 38, "HT" );
        Student student3 = new Student("Tung", 38, "HT" );

        List<Student> lists = new ArrayList<Student>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        Collections.sort(lists);
        for(Student st : lists){
            System.out.println(st.toString());
        }

//        AgeComparator ageComparator = new AgeComparator();
//        Collections.sort(lists,ageComparator);
//        Collections.sort(lists,(s1,s2)->s1.getAge()-s2.getAge());
        Collections.sort(lists, Comparator.comparingInt(Student::getAge));
        System.out.println("So sanh theo tuoi:");
        for(Student st : lists){
            System.out.println(st.toString());
        }
    }
}