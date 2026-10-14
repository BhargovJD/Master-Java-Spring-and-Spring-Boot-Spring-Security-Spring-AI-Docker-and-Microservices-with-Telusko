
import java.sql.*;

public class DemoJdbc {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/chai_store_db";
        String username = "postgres";
        String password = "password";

        // Data stored in Java variables
        int id = 8;
        String chaiName = "Old Tea";
        int price = 40;
        String chaiType = "Green";
        boolean available = true;

        // SQL query with placeholders
        String query = "INSERT INTO chai_store "
                + "(id, chai_name, price, chai_type, available) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {

            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(
                    url, username, password);

            System.out.println("PostgreSQL connected successfully!");

            // Create PreparedStatement
            PreparedStatement pst = con.prepareStatement(query);

            // Set variable values in the placeholders
            pst.setInt(1, id);
            pst.setString(2, chaiName);
            pst.setInt(3, price);
            pst.setString(4, chaiType);
            pst.setBoolean(5, available);

            // Execute INSERT query
            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Chai inserted successfully!");
            }

            pst.close();
            con.close();

            System.out.println("PostgreSQL connection CLOSED!");

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }
    }
}
