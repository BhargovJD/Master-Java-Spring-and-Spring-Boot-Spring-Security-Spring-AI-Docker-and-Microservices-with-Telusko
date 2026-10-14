
import java.sql.*;

public class DemoJdbc {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/chai_store_db";
        String username = "postgres";
        String password = "password";

        // SQL query to insert a new row
        String query = "INSERT INTO chai_store (id, chai_name, price, chai_type, available) "
                + "VALUES (7, 'New chai', 30, 'Milk type', true)";
        try {

            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("PostgreSQL connected successfully!");

            Statement st = con.createStatement();

            // Execute INSERT query
            int rows = st.executeUpdate(query);

            if (rows > 0) {
                System.out.println("Chai inserted successfully!");
            }

            st.close();
            con.close();

            System.out.println("PostgreSQL connection CLOSED!");

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }
    }
}
