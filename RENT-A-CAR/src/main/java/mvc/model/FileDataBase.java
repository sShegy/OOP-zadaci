package mvc.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileDataBase {
    private static FileDataBase instance;

    private final String Vozila="vozila.txt";

    private List<Vozila>vozila=new ArrayList<>();
    private List<Kategorija>kategorija=new ArrayList<>();

    private FileDataBase(){
        ucitajVOzila();
    }
    public static FileDataBase getInstance(){
        if (instance==null){
            instance=new FileDataBase();
        }
        return instance;
    }

    private void ucitajVOzila(){
        try {
            FileReader fr=new FileReader(Vozila);
            BufferedReader bw=new BufferedReader(fr);

            String line= bw.readLine();
            line= bw.readLine();
            line= bw.readLine();
            while (line!=null){
                mvc.model.Vozila v= mvc.model.Vozila.parseVozila(line);
                vozila.add(v);
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
    public Collection<Vozila>getVozila(){
        Set<Vozila>res=new HashSet<>();
        for (Vozila v: vozila){
            res.add(v);
        }
        return res;
    }








}
