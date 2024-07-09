package mvc.model;

import java.util.List;

public class Kategorija {
    private String predavac;
    private String naziv;
    private List<String> oblast;

    public Kategorija(String naziv, List<String> oblast, String predavac) {
        this.naziv = naziv;
        this.oblast = oblast;
        this.predavac = predavac;
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
                '}'+"\n";
    }
}
