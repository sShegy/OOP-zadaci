package mvc.model;

public class Kategorija {
    private String naziv;
    private String kategorija;

    public Kategorija(String kurs, String naziv) {
        this.kategorija = kurs;
        this.naziv = naziv;
    }

    public String getKategorija() {
        return kategorija;
    }

    public String getNaziv() {
        return naziv;
    }
}
