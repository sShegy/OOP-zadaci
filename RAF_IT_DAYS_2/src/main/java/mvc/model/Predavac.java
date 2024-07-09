package mvc.model;

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


}
