
import java.sql.*;

public class DemoJdbc {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/chai_store_db";
        String username = "postgres";
        String password = "password";

        String query = "SELECT * FROM chai_store";

        try {

            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("PostgreSQL connected successfully!");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            // Loop through every row returned by SELECT *
            while (rs.next()) {

                // Retrieve values from each column
                int id = rs.getInt("id");
                String chaiName = rs.getString("chai_name");

                // Print the data
                System.out.println("ID: " + id);
                System.out.println("Chai Name: " + chaiName);
                System.out.println("----------------------");
            }

            rs.close();
            st.close();
            con.close();

            System.out.println("PostgreSQL connection CLOSED!");

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }
    }
}
