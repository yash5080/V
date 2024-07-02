import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


    public class DatabaseCheck {
        public static void main(String[] args) {
            try {
                Conn conn = new Conn();
                String query = "SELECT * FROM admin";  // Change to "customer" to check customer table
                Statement stmt = conn.c.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    System.out.println("Username: " + rs.getString("username"));
                    System.out.println("Password: " + rs.getString("password"));
                }

                rs.close();
                stmt.close();
                conn.c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


