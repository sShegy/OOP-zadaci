package mvc.model;

import com.sun.source.tree.YieldTree;

import java.time.LocalDate;

public class User {

    private String ime;
    private String prezime;
    private String email;
    private String password;
    private String age;
    private String gender;

    public User(String ime, String prezime, String email, String password, String age, String gender) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public static User getParstUser(String s){
        //Milan;Segan;milan@gmail.com;123;20/06/2004;Male
        String[]parst=s.split(";");
        String ime=parst[0];
        String prez=parst[1];
        String email=parst[2];
        String pas=parst[3];
//        String[]parst1=parst[4].split("/");
        String age=parst[4];
        String gender=parst[4];

        return new User(ime,prez,email,pas,age,gender);
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return ime+";"+prezime+";"+email+";"+password+";"+age+";"+gender+"\n";
    }
}
