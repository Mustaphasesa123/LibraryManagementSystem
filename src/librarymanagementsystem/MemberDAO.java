package librarymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

    String url = "jdbc:sqlite:library.db";

    // ADD MEMBER
    public void addMember(Member member) {
        String sql = "INSERT INTO members(member_id, member_name, email, membership_type) VALUES (?, ?, ?, ?)";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, member.getMemberId());
            stmt.setString(2, member.getMemberName());
            stmt.setString(3, member.getEmail());
            stmt.setString(4, member.getMembershipType());

            stmt.executeUpdate();

            System.out.println("Member added successfully!");

            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // VIEW MEMBERS
    public void viewMembers() {
        String sql = "SELECT * FROM members";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Member ID: " + rs.getInt("member_id"));
                System.out.println("Name: " + rs.getString("member_name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Type: " + rs.getString("membership_type"));
                System.out.println("----------------------");
            }

            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // UPDATE MEMBER
    public void updateMember(int memberId, String newEmail) {
        String sql = "UPDATE members SET email = ? WHERE member_id = ?";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, newEmail);
            stmt.setInt(2, memberId);

            stmt.executeUpdate();

            System.out.println("Member updated successfully!");

            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // DELETE MEMBER
    public void deleteMember(int memberId) {
        String sql = "DELETE FROM members WHERE member_id = ?";

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, memberId);

            stmt.executeUpdate();

            System.out.println("Member deleted successfully!");

            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }public void searchMember(String searchName) {
    String sql = "SELECT * FROM members WHERE member_name LIKE ?";

    try {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(url);

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + searchName + "%");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println("Member ID: " + rs.getInt("member_id"));
            System.out.println("Name: " + rs.getString("member_name"));
            System.out.println("Email: " + rs.getString("email"));
            System.out.println("Type: " + rs.getString("membership_type"));
            System.out.println("----------------------");
        }

        conn.close();

    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}
}