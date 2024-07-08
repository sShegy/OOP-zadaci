package mvc.model;

public class Kategorija {

    private String tema;
    private String predavac;
    private String kompanija;
    private String dan;
    private Integer vreme;
    private String vrsta;

    public Kategorija(String dan, String kompanija, String predavac, String tema, Integer vreme, String vrsta) {
        this.dan = dan;
        this.kompanija = kompanija;
        this.predavac = predavac;
        this.tema = tema;
        this.vreme = vreme;
        this.vrsta = vrsta;
    }

    public String getDan() {
        return dan;
    }

    public String getKompanija() {
        return kompanija;
    }

    public String getPredavac() {
        return predavac;
    }

    public String getTema() {
        return tema;
    }

    public Integer getVreme() {
        return vreme;
    }

    public String getVrsta() {
        return vrsta;
    }

    @Override
    public String toString() {
        return "Kategorija{" +
                "dan='" + dan + '\'' +
                ", tema='" + tema + '\'' +
                ", predavac='" + predavac + '\'' +
                ", kompanija='" + kompanija + '\'' +
                ", vreme=" + vreme +
                ", vrsta='" + vrsta + '\'' +
                '}';
    }
}
