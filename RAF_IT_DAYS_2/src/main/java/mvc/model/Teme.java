package mvc.model;

import java.util.List;

public class Teme {
    private String naslov;
    private List<String> oblast;

    public Teme(String naslov, List<String> oblast) {
        this.naslov = naslov;
        this.oblast = oblast;
    }
}
