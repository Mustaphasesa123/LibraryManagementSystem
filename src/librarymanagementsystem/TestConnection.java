import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:library.db");
            System.out.println("Connected!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}