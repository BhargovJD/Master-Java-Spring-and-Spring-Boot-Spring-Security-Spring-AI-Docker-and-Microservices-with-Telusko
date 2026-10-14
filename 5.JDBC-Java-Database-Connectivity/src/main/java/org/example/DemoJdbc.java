
import java.sql.*;

public class DemoJdbc {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/chai_store_db";
        String username = "postgres";
        String password = "password";

        // SQL query to delete an existing row
        String query = "DELETE FROM chai_store WHERE id = 7";

        try {

            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(
                    url, username, password);

            System.out.println("PostgreSQL connected successfully!");

            Statement st = con.createStatement();

            // Execute DELETE query
            int rows = st.executeUpdate(query);

            if (rows > 0) {
                System.out.println("Chai deleted successfully!");
            } else {
                System.out.println("No chai found with the given ID!");
            }

            st.close();
            con.close();

            System.out.println("PostgreSQL connection CLOSED!");

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }
    }
}
