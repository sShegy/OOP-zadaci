package mvc.model;

import java.util.List;

public class Kategorija {
    private String predavac;
    private String naziv;
    private List<String> oblast;
    private String predavaci;

    public Kategorija(String naziv, List<String> oblast, String predavac, String predavaci) {
        this.naziv = naziv;
        this.oblast = oblast;
        this.predavac = predavac;
        this.predavaci = predavaci;
    }

    public String getNaziv() {
        return naziv;
    }

    public List<String> getOblast() {
        return oblast;
    }

    public String getPredavac() {
        return predavac;
    }

    @Override
    public String toString() {
        return "Kategorija{" +
                "naziv='" + naziv + '\'' +
                ", predavac='" + predavac + '\'' +
                ", oblast=" + oblast +
                ", predavaci='" + predavaci + '\'' +
                '}'+"\n";
    }
}
