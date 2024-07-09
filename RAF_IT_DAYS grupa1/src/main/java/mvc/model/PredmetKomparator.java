package mvc.model;

import java.util.Comparator;

public class PredmetKomparator implements Comparator<Kategorija> {
    @Override
    public int compare(Kategorija o1, Kategorija o2) {
        return Integer.compare(o1.getNaziv().length(),o2.getNaziv().length());
    }
}
