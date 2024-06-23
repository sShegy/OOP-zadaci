package setovi;

import java.util.HashSet;
import java.util.Set;

public class MainOsoba {
    public static void main(String[] args) {
        Osoba a1=new Osoba("A");
        Osoba a2=new Osoba("B");
        Osoba a3=new Osoba("C");
        Osoba a4=new Osoba("D");
        Osoba a5=new Osoba("E");

        Set<Osoba> osobe= new HashSet<>();
        osobe.add(a1);
        osobe.add(a2);
        osobe.add(a3);
        osobe.add(a4);
        osobe.add(a5);

        System.out.println(osobe);
    }
}
