package mvc.model;

import java.util.Arrays;
import java.util.List;

public class Teme {
    private String naslov;
    private List<String> oblast;

    public Teme(String naslov, List<String> oblast) {
        this.naslov = naslov;
        this.oblast = oblast;
    }

    public static Teme parstTeme(String input){
        //Napredne Tehnike Backend Razvoja;Backend,DevOps,Cloud
        String[]parst=input.split(";");
        String naslov =parst[0];
        List<String>oblast= Arrays.asList(parst[1].split(","));

        return new Teme(naslov,oblast);
    }

    public String getNaslov() {
        return naslov;
    }

    public List<String> getOblast() {
        return oblast;
    }

    @Override
    public String toString() {
        return naslov+" - "+oblast ;
    }
}
