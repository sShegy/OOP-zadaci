package mvc.model;

public class Vozila {
    private String marka;
    private String model;
    private String tip;
    private Integer broj;
    private Double cena;

    public Vozila(Integer broj, Double cena, String marka, String model, String tip) {
        this.broj = broj;
        this.cena = cena;
        this.marka = marka;
        this.model = model;
        this.tip = tip;
    }

    public static Vozila parseVozila(String s) {
        // Toyota     RAV4                SUV          5                80.0
        String[] parts = s.trim().split("\\s+");
        Integer broj = Integer.parseInt(parts[3]);
        Double cena = Double.parseDouble(parts[4]); // Use Double.parseDouble() for decimal numbers
        String marka = parts[0];
        String model = parts[1];
        String tip = parts[2];

        return new Vozila(broj, cena, marka, model, tip); // Convert Double to int if necessary
    }




    public Integer getBroj() {
        return broj;
    }

    public Double getCena() {
        return cena;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public String getTip() {
        return tip;
    }

    @Override
    public String toString() {
        return tip+" Cena po danu: "+cena;
    }
}
