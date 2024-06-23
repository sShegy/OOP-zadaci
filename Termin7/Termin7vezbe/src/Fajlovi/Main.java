package Fajlovi;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file=new File("out.txt");
        try {
            FileWriter fw =new FileWriter(file,true);
            BufferedWriter bw=new BufferedWriter(fw);
            fw.write("\nLaki je mali makmun");
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}