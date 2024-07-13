package mvc.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class FileDataBase {
    private static FileDataBase instance;

    private final String User= "User.txt";

    private List<User>user=new ArrayList<>();

    private FileDataBase(){
        ucitajUsers();
    }
    public static FileDataBase getInstance(){
        if (instance==null){
            instance=new FileDataBase();
        }
        return instance;
    }
    public boolean Useexiat(User u){
        for (mvc.model.User r:user){
            if (r.getAge().equals(u.getAge())){
                return true;
            }
        }
        return false;
    }
    public void getUserInList(User u){
        user.add(u);
    }

    private void ucitajUsers(){
    try {
        FileReader fr=new FileReader(User);
        BufferedReader bw=new BufferedReader(fr);
        String line= bw.readLine();
        while (line!=null){
            mvc.model.User u= mvc.model.User.getParstUser(line);
            System.out.printf(u.toString());
            user.add(u);
            line= bw.readLine();
        }

    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }

    public boolean eculEmail(User u){
        for (mvc.model.User t:user){
            if (t.getEmail().equals(u.getEmail())){
                return true;
            }
        }
        return false;
    }




}
