package mvc.model;

public class Currency {
    //3.6725;AED;United Arab Emirates
    private Double cena;
    private String nameCurrency;
    private String drzava;

    public Currency(Double cena, String drzava, String nameCurrency) {
        this.cena = cena;
        this.drzava = drzava;
        this.nameCurrency = nameCurrency;
    }
    public static Currency getCurrency(String c){
        String[]parst=c.split(";");
        Double cena=Double.parseDouble(parst[0]);
        String drzava=parst[2];
        String nameCurrency=parst[1];

        return new Currency(cena,drzava,nameCurrency);
    }

    public Double getCena() {
        return cena;
    }

    public String getDrzava() {
        return drzava;
    }

    public String getNameCurrency() {
        return nameCurrency;
    }
}
