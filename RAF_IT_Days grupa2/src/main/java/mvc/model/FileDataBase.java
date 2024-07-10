package mvc.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileDataBase {
    private static FileDataBase instance;

    private final String Predavac = "predavaci.txt";
    private final String Teme = "teme.txt";

    private List<Predavac> predavac = new ArrayList<>();
    private List<Teme> teme = new ArrayList<>();
    private List<Kategorija> kategorija = new ArrayList<>();

    private FileDataBase() {
        ucitajPredavaca();
        ucitajTeme();
    }

    public static FileDataBase getInstance() {
        if (instance == null) {
            instance = new FileDataBase();
        }
        return instance;
    }
    public  void getKategorijeubazu(Kategorija k){
        kategorija.add(k);
    }

    private void ucitajPredavaca() {
        try {
            FileReader fr = new FileReader(Predavac);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            while (line != null) {
                Predavac p = mvc.model.Predavac.getPredavac(line);
                predavac.add(p);
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void ucitajTeme() {
        try {
            FileReader fr = new FileReader(Teme);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            while (line != null) {
                Teme t = mvc.model.Teme.getTeme(line);
                teme.add(t);
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<Predavac> getPredmet() {
        Set<Predavac> pr = new HashSet<>();
        for (Predavac p : predavac) {
            pr.add(p);
        }
        return pr;
    }

    public Collection<Teme> getTeme() {
        Set<Teme> pr = new HashSet<>();
        for (Teme p : teme) {
            pr.add(p);
        }
        return pr;
    }
    public Collection<Predavac>getPredmetFilter(String s){
        Set<Predavac>pr=new HashSet<>();
        for (mvc.model.Predavac p:predavac){
            if (p.getOblast().contains(s)){
                pr.add(p);
            }
        }
        return pr;
    }
    public Collection<Teme> getTemeFilter(String s){
        Set<Teme>pr=new HashSet<>();
        for (Teme p:teme){
            if (p.getOblast().contains(s)){
                pr.add(p);
            }
        }
        return pr;
    }


    public List<String> getUniqueOblasti() {
        Set<String> uniqueOblasti = new HashSet<>();
        uniqueOblasti.add("Sve oblasti");
        for (Teme t : teme) {
            uniqueOblasti.addAll(t.getOblast());
        }
        return new ArrayList<>(uniqueOblasti);
    }
    public Collection<Kategorija>getKategorijatv(){
        Set<Kategorija>kp=new HashSet<>();
        for (Kategorija k:kategorija){
            kp.add(k);
        }
        return kp;
    }

    public List<Kategorija> getKategorija() {
        return kategorija;
    }

    public List<mvc.model.Predavac> getPredavac() {
        return predavac;
    }
}
