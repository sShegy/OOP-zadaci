package mvc.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class FileDataBase {
    private static FileDataBase instance;

    private final String Kurs="/Users/shegy/Documents/OOP-zadaci/Kurs/RAF_Coursera.txt";

    private static int Dzeparac=1000;
    private int ime;

    private List<Kurs>odabranikurs=new ArrayList<>();
    private List<Kategorija>dadada=new ArrayList<>();
    private List<Kurs>kursevci=new ArrayList<>();

    private FileDataBase() {

        ucitajKurs();

    }
    public static FileDataBase getInstance(){
        if (instance==null){
            instance=new FileDataBase();
        }
        return instance;
    }
    public boolean Kursexist(Kurs kurs){
        for (Kurs k:odabranikurs){
            if (k.equals(kurs)){
                return true;
            }
        }
            return false;
    }

    public Collection<Integer>getSate(){
        Set<Integer>sat=new LinkedHashSet<>();
        for (int i=1;i<=24;i++){
            sat.add(i);
        }
        return sat;
    }
    public Collection<Integer>getMinute(){
        Set<Integer>sat=new LinkedHashSet<>();
        for (int i=0;i<=60;i=i+5){
            sat.add(i);
        }
        return sat;
    }
    public Collection<Kategorija>getKategorija(){
        Set<Kategorija>sat=new LinkedHashSet<>();
        for (Kategorija k:dadada){
            sat.add(k);
        }
        return sat;
    }
    public int uzmiDzeparac(Integer i){
        Dzeparac-=i;
        return Dzeparac;
    }



    private void ucitajKurs(){
        try {
            FileReader fr=new FileReader(Kurs);
            BufferedReader bf=new BufferedReader(fr);

            String line= bf.readLine();

            while (line!=null){
                mvc.model.Kurs k= mvc.model.Kurs.parsetKurs(line);
                kursevci.add(k);
                line= bf.readLine();
            }
            bf.close();
            fr.close();
        }catch (Exception e){

        }

    }
    public void dodatikurs(Kurs kurs){
        odabranikurs.add(kurs);
    }


    public List<mvc.model.Kurs> getKursevci() {
        return kursevci;
    }

    public List<mvc.model.Kurs> getOdabranikurs() {
        return odabranikurs;
    }

    public int getDzeparac(Integer i) {
        Dzeparac=Dzeparac-i;
        return Dzeparac;
    }

    public List<Kategorija> getDadada() {
        return dadada;
    }
}
