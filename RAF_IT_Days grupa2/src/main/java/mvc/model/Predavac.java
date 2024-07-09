package mvc.model;

import java.util.Arrays;
import java.util.List;

public class Predavac {

    private String ime;
    private String prezime;
    private String kompanija;
    private List<String> oblast;

    public Predavac(String ime, String kompanija, List<String> oblast, String prezime) {
        this.ime = ime;
        this.kompanija = kompanija;
        this.oblast = oblast;
        this.prezime = prezime;
    }

    public static Predavac getPredavac(String st){
    //    Markovic;Marko;Nordeus;Backend,Gaming,DevOps
        String[]parst=st.split(";");
        String ime=parst[1];
        String prezime=parst[0];
        String kompanija=parst[2];
        List<String> oblast= Arrays.asList(parst[3].split(","));

        return new Predavac(ime,kompanija,oblast,prezime) ;
    }

    public String getIme() {
        return ime;
    }

    public String getKompanija() {
        return kompanija;
    }

    public List<String> getOblast() {
        return oblast;
    }

    public String getPrezime() {
        return prezime;
    }

    @Override
    public String toString() {
        return prezime+""+ime+"-"+kompanija;
    }
}
