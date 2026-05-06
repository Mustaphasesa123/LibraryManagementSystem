package librarymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BorrowRecordDAO {

    String url = "jdbc:sqlite:library.db";

    // ADD BORROW RECORD
    public void addBorrowRecord(BorrowRecord record) {
        String sql = "INSERT INTO borrow_records(record_id, book_id, member_id, borrow_date, due_date, return_status) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, record.getRecordId());
            stmt.setInt(2, record.getBookId());
            stmt.setInt(3, record.getMemberId());
            stmt.setString(4, record.getBorrowDate());
            stmt.setString(5, record.getDueDate());
            stmt.setString(6, record.getReturnStatus());

            stmt.executeUpdate();

            System.out.println("Borrow record added successfully!");

            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // VIEW BORROW RECORDS
    public void viewBorrowRecords() {
        String sql = "SELECT * FROM borrow_records";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Record ID: " + rs.getInt("record_id"));
                System.out.println("Book ID: " + rs.getInt("book_id"));
                System.out.println("Member ID: " + rs.getInt("member_id"));
                System.out.println("Borrow Date: " + rs.getString("borrow_date"));
                System.out.println("Due Date: " + rs.getString("due_date"));
                System.out.println("Status: " + rs.getString("return_status"));
                System.out.println("----------------------");
            }

            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // UPDATE BORROW STATUS
    public void updateBorrowStatus(int recordId, String newStatus) {
        String sql = "UPDATE borrow_records SET return_status = ? WHERE record_id = ?";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, newStatus);
            stmt.setInt(2, recordId);

            stmt.executeUpdate();

            System.out.println("Borrow record updated successfully!");

            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // DELETE BORROW RECORD
    public void deleteBorrowRecord(int recordId) {
        String sql = "DELETE FROM borrow_records WHERE record_id = ?";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, recordId);

            stmt.executeUpdate();

            System.out.println("Borrow record deleted successfully!");

            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }public void viewOverdueBooks() {
    String sql = "SELECT * FROM borrow_records WHERE due_date < date('now') AND return_status = 'Borrowed'";

    try {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(url);

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println("Record ID: " + rs.getInt("record_id"));
            System.out.println("Book ID: " + rs.getInt("book_id"));
            System.out.println("Member ID: " + rs.getInt("member_id"));
            System.out.println("Due Date: " + rs.getString("due_date"));
            System.out.println("Status: OVERDUE");
            System.out.println("----------------------");
        }

        conn.close();

    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}public void searchBorrowRecord(int memberId) {
    String sql = "SELECT * FROM borrow_records WHERE member_id = ?";

    try {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(url);

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, memberId);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println("Record ID: " + rs.getInt("record_id"));
            System.out.println("Book ID: " + rs.getInt("book_id"));
            System.out.println("Member ID: " + rs.getInt("member_id"));
            System.out.println("Borrow Date: " + rs.getString("borrow_date"));
            System.out.println("Due Date: " + rs.getString("due_date"));
            System.out.println("Status: " + rs.getString("return_status"));
            System.out.println("----------------------");
        }

        conn.close();

    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}
}