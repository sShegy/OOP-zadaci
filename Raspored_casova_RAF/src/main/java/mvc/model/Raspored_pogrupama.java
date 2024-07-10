package mvc.model;

import java.util.List;

public class Raspored_pogrupama {
    private String grupa;
    private List<Raspored> raspored;

    public Raspored_pogrupama(String grupa, List<Raspored> raspored) {
        this.grupa = grupa;
        this.raspored = raspored;
    }

    public String getGrupa() {
        return grupa;
    }

    public List<Raspored> getRaspored() {
        return raspored;
    }
}