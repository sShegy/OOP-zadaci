package mvc.model;

public class Kurs {
    private  String naziv;
    private  String kategorija;
    private String trajanje;
    private  String cena;

    public Kurs(String cena, String kategorija, String naziv, String trajanje) {
        this.cena = cena;
        this.kategorija = kategorija;
        this.naziv = naziv;
        this.trajanje = trajanje;
    }



    public static Kurs parsetKurs(String input){
        //Introduction to Web Development,Technology>480 minutes:$99
         String[]parsenza=input.split(",");
         String naziv=parsenza[0];
         String[]parsetkat=parsenza[1].split(">");
         String kategorija=parsetkat[0];
         String[]parsetkatrajanje=parsetkat[1].split(":");
         String trajanje=parsetkatrajanje[0];
         String cena=parsetkatrajanje[1];
        return new Kurs(cena,kategorija,naziv,trajanje);

    }


    public String getCena() {
        return cena;
    }

    public String getKategorija() {
        return kategorija;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getTrajanje() {
        return trajanje;
    }

    @Override
    public String toString() {
        return naziv+"/"+kategorija+"/"+trajanje+"/"+cena;
    }
}

