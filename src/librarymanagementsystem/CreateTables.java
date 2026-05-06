import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTables {
    public static void main(String[] args) {
        
        String url = "jdbc:sqlite:library.db";

        String booksTable = "CREATE TABLE IF NOT EXISTS books ("
                + "book_id INTEGER PRIMARY KEY, "
                + "title TEXT NOT NULL, "
                + "author TEXT NOT NULL, "
                + "category TEXT NOT NULL, "
                + "availability_status TEXT NOT NULL"
                + ");";

        String membersTable = "CREATE TABLE IF NOT EXISTS members ("
                + "member_id INTEGER PRIMARY KEY, "
                + "member_name TEXT NOT NULL, "
                + "email TEXT NOT NULL, "
                + "membership_type TEXT NOT NULL"
                + ");";

        String borrowTable = "CREATE TABLE IF NOT EXISTS borrow_records ("
                + "record_id INTEGER PRIMARY KEY, "
                + "book_id INTEGER NOT NULL, "
                + "member_id INTEGER NOT NULL, "
                + "borrow_date DATE NOT NULL, "
                + "due_date DATE NOT NULL, "
                + "return_status TEXT NOT NULL"
                + ");";

        try {
            // Load SQLite driver
            Class.forName("org.sqlite.JDBC");

            // Connect to database
            Connection conn = DriverManager.getConnection(url);

            // Create statement
            Statement stmt = conn.createStatement();

            // Create tables
            stmt.execute(booksTable);
            stmt.execute(membersTable);
            stmt.execute(borrowTable);

            System.out.println("Tables created successfully!");

            // Close connection
            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
        }
    }
}