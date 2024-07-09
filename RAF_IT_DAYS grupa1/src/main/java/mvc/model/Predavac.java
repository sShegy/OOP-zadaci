package mvc.model;

import java.util.Arrays;
import java.util.List;

public class Predavac {
    //prezime, ime, naziv kompanije u kojoj radi, status i oblasti u kojima je stručan
    //Markovic;Marko;Nordeus;Potvrdjen;Backend,Gaming,DevOps
    private String ime;
    private String prezime;
    private String kompanija;
    private String status;
    private List<String> oblast;

    public Predavac(String ime, String kompanija, List<String> oblast, String prezime, String status) {
        this.ime = ime;
        this.kompanija = kompanija;
        this.oblast = oblast;
        this.prezime = prezime;
        this.status = status;
    }

    public static Predavac parstPredavac(String input){
        //Markovic;Marko;Nordeus;Potvrdjen;Backend,Gaming,DevOps
        String[]parst=input.split(";");
        String ime=parst[1];
        String kompanija=parst[2];
        List<String>oblast= Arrays.asList(parst[4].split(","));
        String prezime=parst[0];
        String status=parst[3];


        return new Predavac(ime,kompanija,oblast,prezime,status);
    }

    @Override
    public String toString() {
        return ime+""+prezime;
    }
    public String getPred(){
        return  ime+" "+prezime;
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

    public String getStatus() {
        return status.toUpperCase();
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
