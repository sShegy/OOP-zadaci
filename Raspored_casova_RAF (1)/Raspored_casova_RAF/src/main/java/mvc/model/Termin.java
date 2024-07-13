package mvc.model;

import java.util.Arrays;
import java.util.List;

public class Termin implements Comparable<Termin> {

    private String predmet;
    private String nastavnik;
    private String vrsta;
    private String ucionica;
    private int vremeOd;
    private int vremeDo;
    private String dan;
    private List<String> grupe;

    public Termin(String predmet, String nastavnik, String vrsta, String ucionica, int vremeOd, int vremeDo, String dan, List<String> grupe) {
        this.predmet = predmet;
        this.nastavnik = nastavnik;
        this.vrsta = vrsta;
        this.ucionica = ucionica;
        this.vremeOd = vremeOd;
        this.vremeDo = vremeDo;
        this.dan = dan;
        this.grupe = grupe;
    }

    // Milovic Njegovan;ČET;Raf3;15;18;Vezbe;2s1
    public static Termin parseTermin(String[] parts, String nazivPredmeta) {
        String nastavnik = parts[0];
        String dan = parts[1];
        String ucionica = parts[2];
        int vremeOd = Integer.parseInt(parts[3]);
        int vremeDo = Integer.parseInt(parts[4]);
        String vrsta = parts[5];
        List<String> grupe = Arrays.asList(parts[6].split(" "));

        return new Termin(nazivPredmeta, nastavnik, vrsta, ucionica, vremeOd, vremeDo, dan, grupe);
    }

    public String getPredmet() {
        return predmet;
    }

    public String getNastavnik() {
        return nastavnik;
    }

    public String getVrsta() {
        return vrsta;
    }

    public String getUcionica() {
        return ucionica;
    }

    public String getTermin() {
        return vremeOd + "-" + vremeDo;
    }

    public String getDan() {
        return dan;
    }

    public List<String> getGrupe() {
        return grupe;
    }

    @Override
    public int compareTo(Termin o) {
        if (danValue(this.dan) == danValue(o.dan)) {
            return getTermin().compareTo(o.getTermin());
        }

        return Integer.compare(danValue(this.dan), danValue(o.dan));
    }

    public int danValue(String dan) {
        switch (dan) {
            case "PON":
                return 1;
            case "UTO":
                return 2;
            case "SRE":
                return 3;
            case "ČET":
                return 4;
            case "PET":
                return 5;
            default:
                return 6;
        }
    }
}
