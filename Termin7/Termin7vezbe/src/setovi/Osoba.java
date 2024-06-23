package setovi;

import java.util.Objects;

public class Osoba {
    private String ime;

    public Osoba(String ime) {
        this.ime = ime;
    }

    @Override
    public String toString() {
        return ime;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        return Objects.equals(ime, osoba.ime);
    }

    @Override
    public int hashCode() {
        System.out.println("Pozvao si hash osobu: "+ime+"Cigan");
        return Objects.hashCode(ime);
    }
}
