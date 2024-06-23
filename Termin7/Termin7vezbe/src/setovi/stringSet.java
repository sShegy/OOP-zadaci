package setovi;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class stringSet {
    public static void main(String[] args) {
    LinkedHashSet();
    treeSet();
    }
    public static void hashSet(){
        Set<String>hashString=new HashSet<>();

        hashString.add("jedan");
        hashString.add("dva");
        hashString.add("tri");
        hashString.add("jedan");

        System.out.println(hashString);
    }
    public static void LinkedHashSet(){
        Set<String>hashString=new LinkedHashSet<>();

        hashString.add("jedan");
        hashString.add("dva");
        hashString.add("tri");
        hashString.add("jedan");

        System.out.println(hashString);
    }
    public static void treeSet(){
        Set<String>hashString=new TreeSet<>();

        hashString.add("jedan");
        hashString.add("dva");
        hashString.add("tri");
        hashString.add("jedan");

        System.out.println(hashString);
    }

}
