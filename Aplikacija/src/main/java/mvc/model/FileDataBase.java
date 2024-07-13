package mvc.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileDataBase {
    private static FileDataBase instance;

    private final String USER_FILE = "User.txt";
    private final String Currency_FILE = "Currency.txt";

    private List<User> user = new ArrayList<>();
    private List<Currency> currencie = new ArrayList<>();

    private FileDataBase() {
        ucitajUsers();
        ucitajCurrency();
    }



    public static FileDataBase getInstance() {
        if (instance == null) {
            instance = new FileDataBase();
        }
        return instance;
    }

    public boolean useExist(User u) {
        for (User r : user) {
            if (r.getEmail().equals(u.getEmail())) {
                if (r.getPassword().equals(u.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean userExist(String email, String password) {
        for (User u : user) {
            if (u.getEmail().equals(email)) {
                System.out.println("Email postoji");
                if (u.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void getUserInList(User u) {
        user.add(u);
    }

    private void ucitajUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;  // Skip empty lines
                }
                User u = User.getParstUser(line);
                if (u != null) {
                    System.out.println(u.toString());
                    user.add(u);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("User file not found: " + USER_FILE);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error reading user file: " + USER_FILE);
            e.printStackTrace();
        }
    }
    private void ucitajCurrency() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(Currency_FILE));
            String line = br.readLine();
            while (line!=null){
                Currency c=Currency.getCurrency(line);
                currencie.add(c);
                line= br.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public Collection<String>getDrzave(){
        Set<String>res=new LinkedHashSet<>();
        for (Currency c:currencie){
            res.add(c.getDrzava());
        }
        return res;
    }

    public boolean emailExists(User u) {
        for (User t : user) {
            if (t.getEmail().equals(u.getEmail())) {
                return true;
            }
        }
        return false;
    }
    public String getValueCurrency(String s){
        for (Currency c:currencie){
            if (c.getDrzava().equals(s)){
                return c.getNameCurrency();
            }
        }
        return s;
    }
    public Double getValu(String s){
        for (Currency c:currencie){
            if (c.getDrzava().equals(s)){
                return c.getCena();
            }
        }
        return 0.0;
    }
    public Collection<Currency>getdrzavezalistu(String s){
        Set<Currency> res=new LinkedHashSet<>();
        for (Currency c:currencie){
            if (c.getDrzava().contains(s)){
                res.add(c);
            }
        }
        return res;
    }


    public List<Currency> getCurrencie() {
        return currencie;
    }
}
