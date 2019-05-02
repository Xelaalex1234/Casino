package ch.bbbaden.casino;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
public class User {

    private String username, password;
    protected Connection connie;
    private Statement statement;
    private ResultSet rs;
    private boolean admin;

    public User(boolean admin){
        this.admin = admin;
    }

    public void login(String username, String password) throws SQLException {
        this.username = username;
        this.password = password;

        openConnection();

        statement = connie.createStatement();
        if(admin) {
            rs = statement.executeQuery("SELECT * FROM `adminusers`");
        }
        else {
            rs = statement.executeQuery("SELECT * FROM `normalusers`");
        }

        while (rs.next()) {
            if (rs.getString(1).equals(username)) {
                try {
                    if (calculateHash(password).equals(rs.getString(2))) {
                        return;
                    } else {
                        throw new SQLException("Falsches Passwort");
                    }
                } catch (NoSuchAlgorithmException e) {
                    System.err.println(e);
                }
            }
        }
        throw new SQLException("Benutzer nicht gefunden");
    }


    public String calculateHash(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return myHash;
    }

    public void openConnection() throws SQLException {
        connie = DriverManager.getConnection("jdbc:mysql://localhost:3306/casino", "root", "");
    }

    public boolean userExists(String username) throws SQLException {
        statement = connie.createStatement();
        rs = statement.executeQuery("SELECT * FROM `normalusers`");
        while (rs.next()) {
            if (rs.getString(1).equals(username)) {
                return true;
            }
        }
        return false;
    }

    public String getUsername() {
        return username;
    }
}