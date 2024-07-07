package mvc.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Kategorija {
    private String naziv;
    private String kategorija;
    private LocalDate pocetakdt;
    private LocalTime pocetakvr;
    private String krajdt;
    private String krajvr;


    public Kategorija(String kategorija, String krajdt, String krajvr, String naziv, LocalDate pocetakdt, LocalTime pocetakvr) {
        this.kategorija = kategorija;
        this.krajdt = krajdt;
        this.krajvr = krajvr;
        this.naziv = naziv;
        this.pocetakdt = pocetakdt;
        this.pocetakvr = pocetakvr;
    }

    public String getKategorija() {
        return kategorija;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getKrajdt() {
        return krajdt;
    }

    public String getKrajvr() {
        return krajvr;
    }

    public LocalDate getPocetakdt() {
        return pocetakdt;
    }

    public LocalTime getPocetakvr() {
        return pocetakvr;
    }

    @Override
    public String toString() {
        return "Kategorija{" +
                "kategorija='" + kategorija + '\'' +
                ", naziv='" + naziv + '\'' +
                ", pocetakdt=" + pocetakdt +
                ", pocetakvr=" + pocetakvr +
                ", krajdt='" + krajdt + '\'' +
                ", krajvr='" + krajvr + '\'' +
                '}'+"\n";
    }
}
