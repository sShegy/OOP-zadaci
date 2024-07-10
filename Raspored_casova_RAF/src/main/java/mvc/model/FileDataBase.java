package mvc.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

public class FileDataBase {
    private static FileDataBase insatnce;
    private final  String Raspored="rasporedPoPredmetima-grupa1.txt";


    private List<Raspored_pogrupama>glavniraspord=new ArrayList<>();
    private List<Raspored>raspored=new ArrayList<>();
    private List<String>cb=new ArrayList<>();
    private List<Kategorija>kategorija=new ArrayList<>();
    private Integer br=0;

    private FileDataBase(){
        ucitajRaspored();
    }
    public static FileDataBase getInstance(){
        if (insatnce==null){
            insatnce=new FileDataBase();
        }
        return insatnce;
    }
    //Racunarske komunikacije
    //Milovic Njegovan;ČET;Raf3;15;18;Vezbe;2s1
    private void ucitajRaspored() {
        try {
            FileReader fr=new FileReader(Raspored);
            BufferedReader bw=new BufferedReader(fr);

            String header= bw.readLine();;
            String line= bw.readLine();;

            while (line!=null){
                String[]parst=line.split(";");
                if (parst.length==1){
                    glavniraspord.add(new Raspored_pogrupama(header,raspored));
                header=parst[0];
                raspored.clear();
                }else {
                    raspored.add(mvc.model.Raspored.getRaspored(parst));
                }
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
    public Collection<Raspored_pogrupama>getRaspored(){
        Set<Raspored_pogrupama>res=new HashSet<>();
        for (Raspored_pogrupama r: glavniraspord){
            res.add(r);
        }
        return res;
    }



}
