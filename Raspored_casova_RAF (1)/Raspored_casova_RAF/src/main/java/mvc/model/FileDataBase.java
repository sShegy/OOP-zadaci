package mvc.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileDataBase {
    private static FileDataBase insatnce;

    private final String TERMINI_PATH = "rasporedPoPredmetima-grupa1.txt";

    private final List<Termin> termini = new ArrayList<>();
    private final Set<String> grupe = new TreeSet<>();

    private FileDataBase(){
        ucitajTermine();
    }

    public static FileDataBase getInstance(){
        if (insatnce==null){
            insatnce=new FileDataBase();
        }
        return insatnce;
    }

    // Racunarske komunikacije
    // Milovic Njegovan;ČET;Raf3;15;18;Vezbe;2s1
    private void ucitajTermine() {
        try {
            FileReader fr=new FileReader(TERMINI_PATH);
            BufferedReader bw=new BufferedReader(fr);

            String nazivPredmeta = bw.readLine();
            String line = bw.readLine();

            while (line!=null) {
                String[] parts = line.split(";");
                if (parts.length == 1) {
                    nazivPredmeta = parts[0];
                } else {
                    Termin termin = Termin.parseTermin(parts, nazivPredmeta);
                    termini.add(termin);
                    grupe.addAll(termin.getGrupe());
                }

                line= bw.readLine();
            }

            fr.close();
            bw.close();
        } catch (Exception e) {
            // TODO - handle
        }

        termini.sort(null);
    }

    public List<Termin> getTermini() {
        return termini;
    }

    public List<Termin> getTermini(String grupa) {
        List<Termin> terminiZaGrupu = new ArrayList<>();
        for (Termin termin : termini) {
            if (termin.getGrupe().contains(grupa)) {
                terminiZaGrupu.add(termin);
            }
        }

        terminiZaGrupu.sort(null);
        return terminiZaGrupu;
    }

    public Set<String> getGrupe() {
        return grupe;
    }
}
