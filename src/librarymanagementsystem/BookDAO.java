package librarymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO {

    String url = "jdbc:sqlite:library.db";

    // ADD BOOK
    public void addBook(Book book) {
        String sql = "INSERT INTO books(book_id, title, author, category, availability_status) VALUES (?, ?, ?, ?, ?)";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, book.getBookId());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setString(4, book.getCategory());
            stmt.setString(5, book.getAvailabilityStatus());

            stmt.executeUpdate();

            System.out.println("Book added successfully!");

            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // VIEW BOOKS
    public void viewBooks() {
        String sql = "SELECT * FROM books";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Book ID: " + rs.getInt("book_id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Category: " + rs.getString("category"));
                System.out.println("Status: " + rs.getString("availability_status"));
                System.out.println("----------------------");
            }

            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // UPDATE BOOK
    public void updateBook(int bookId, String newTitle) {
        String sql = "UPDATE books SET title = ? WHERE book_id = ?";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, newTitle);
            stmt.setInt(2, bookId);

            stmt.executeUpdate();

            System.out.println("Book updated successfully!");

            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // DELETE BOOK
    public void deleteBook(int bookId) {
        String sql = "DELETE FROM books WHERE book_id = ?";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, bookId);

            stmt.executeUpdate();

            System.out.println("Book deleted successfully!");

            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // SEARCH BOOK
    public void searchBook(String searchTitle) {
        String sql = "SELECT * FROM books WHERE title LIKE ?";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + searchTitle + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Book ID: " + rs.getInt("book_id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Category: " + rs.getString("category"));
                System.out.println("Status: " + rs.getString("availability_status"));
                System.out.println("----------------------");
            }

            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}