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

    public static Teme getTeme(String st) {
        // Napredne Tehnike Backend Razvoja;Backend,DevOps,Cloud

            String[] parts = st.split(";");
            String naslov = parts[0];
            List<String> oblast = Arrays.asList(parts[1].split(","));
            return new Teme(naslov, oblast);

    }

    public String getNaslov() {
        return naslov;
    }

    public List<String> getOblast() {
        return oblast;
    }

    @Override
    public String toString() {
        return naslov;
    }
}
