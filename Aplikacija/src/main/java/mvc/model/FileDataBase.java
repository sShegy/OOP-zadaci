package mvc.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataBase {
    private static FileDataBase instance;

    private final String USER_FILE = "User.txt";

    private List<User> user = new ArrayList<>();

    private FileDataBase() {
        ucitajUsers();
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


    public boolean emailExists(User u) {
        for (User t : user) {
            if (t.getEmail().equals(u.getEmail())) {
                return true;
            }
        }
        return false;
    }
}
