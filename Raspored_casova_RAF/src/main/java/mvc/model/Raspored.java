package mvc.model;

import java.util.Arrays;
import java.util.List;

public class Raspored {
    //Milovic Njegovan;ČET;Raf3;15;18;Vezbe;2s1
    private String naziv;
    private String dan;
    private String ucionica;
    private String poc;
    private String zav;
    private String vrsta;
    private List<String> grupa;


    public Raspored(String dan, List<String> grupa, String naziv, String poc, String ucionica, String vrsta, String zav) {
        this.dan = dan;
        this.grupa = grupa;
        this.naziv = naziv;
        this.poc = poc;
        this.ucionica = ucionica;
        this.vrsta = vrsta;
        this.zav = zav;
    }

    public static Raspored getRaspored(String[]parst){
        //Radosavljevic Nemanja;SRE;Raf6;11;14;Predavanja;2s1 2s2 2s3
        String dan=parst[1];
        List<String>grupa= Arrays.asList(parst[6].split(" "));
        String naziv=parst[0];
        String poc=parst[3];
        String ucionica=parst[2];
        String vrsta=parst[5];
        String zav=parst[4];


        return new Raspored(dan,grupa,naziv,poc,ucionica,vrsta,zav);
    }

    public String getDan() {
        return dan;
    }

    public List<String> getGrupa() {
        return grupa;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getPoc() {
        return poc;
    }

    public String getUcionica() {
        return ucionica;
    }

    public String getVrsta() {
        return vrsta;
    }

    public String getZav() {
        return zav;
    }
    public String getTermin(){
        return poc+"-"+zav;
    }

}
