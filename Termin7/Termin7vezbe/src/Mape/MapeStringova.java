package Mape;

import java.util.*;

public class MapeStringova {
    public static void main(String[] args) {
        Map<String, Integer> map=new HashMap<>();
        map.put("jedan", 1);
        map.put("dva", 2);
        map.put("tri", 3);

        Collection<Integer> key=map.values();
        //System.out.println(key);

        Set<Map.Entry<String,Integer>>entrySet=map.entrySet();
        for(Map.Entry<String,Integer>entry:entrySet){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
