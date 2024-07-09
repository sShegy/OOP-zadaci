package mvc.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileDataBase {
    private static FileDataBase instance;

    private final String Predavac="predavaci.txt";
    private final String Teme="teme.txt";

    private List<Predavac>predavac=new ArrayList<>();
    private List<Teme>teme=new ArrayList<>();
    private List<Kategorija>kategorija=new ArrayList<>();


    private FileDataBase(){
        ucitajPredavaca();
        ucitajTeme();
    }

    public static FileDataBase getInstance(){
        if (instance==null){
            instance=new FileDataBase();
        }
        return instance;
    }
    public void getKategorijalv(Kategorija k){
        kategorija.add(k);//dodaj Kategoriju u listu katagoriju
    }

    public void removerTema(Teme k){
        teme.remove(k);
    }


    private void ucitajTeme() {
        try {
            FileReader fr=new FileReader(Predavac);
            BufferedReader bw=new BufferedReader(fr);

            String line= bw.readLine();
            while (line!=null){
                Predavac p= mvc.model.Predavac.parstPredavac(line);
                predavac.add(p);

                line= bw.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void ucitajPredavaca() {
        try {
            FileReader fr=new FileReader(Teme);
            BufferedReader bw=new BufferedReader(fr);

            String line= bw.readLine();
            while (line!=null){
                mvc.model.Teme p= mvc.model.Teme.parstTeme(line);
                teme.add(p);
                line= bw.readLine();
            }
            fr.close();
            bw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<Predavac>getPredavac(){
        Set<Predavac>res=new HashSet<>();
        for (mvc.model.Predavac p: predavac){
            res.add(p);
        }
        return res;
    }
    public Collection<Teme>getTeme(){
        Set<Teme>res=new HashSet<>();
        for (mvc.model.Teme t: teme){
            res.add(t);
        }
        return res;
    }
    public Collection<Predavac>getPredavacStatus(String s){
        Set<Predavac>res=new HashSet<>();
        for (mvc.model.Predavac p: predavac){
            if (p.getStatus().equals(s)){
                res.add(p);
            }
        }
        return res;
    }

    public List<Kategorija> getKategorija() {
        return kategorija;
    }
}
