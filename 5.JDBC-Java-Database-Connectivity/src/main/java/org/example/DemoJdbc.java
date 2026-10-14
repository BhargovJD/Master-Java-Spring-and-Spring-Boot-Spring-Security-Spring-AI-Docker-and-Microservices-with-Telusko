
import java.sql.*; // Imports JDBC classes and interfaces from the java.sql package, such as Connection, Statement, and ResultSet.

public class DemoJdbc { // 'public' is an access modifier; 'class' defines a class; DemoJdbc is the class name.

    public static void main(String[] args) { // 'public' is an access modifier, 'static' means no object is needed to call main, 'void' is the return type, main is a method, and args is a String array parameter.

        String url = "jdbc:postgresql://localhost:5432/chai_store_db"; // String is a class, url is a local reference variable, and the assigned value is the database connection URL.

        String username = "postgres"; // String is a class, username is a local reference variable, and "postgres" is the database username.

        String password = "password"; // String is a class, password is a local reference variable, and "password" is the database password.

//        String query = "SELECT chai_name FROM chai_store WHERE id=1"; // String is a class, query is a local reference variable, and the value is an SQL query.
        String query = "SELECT * FROM chai_store "; // String is a class, query is a local reference variable, and the value is an SQL query.


        try { // 'try' is a keyword used to execute code that may throw exceptions.

            Class.forName("org.postgresql.Driver"); // Class is a built-in Java class, forName() is a static method, and this loads the PostgreSQL JDBC driver class.

            Connection con = DriverManager.getConnection(url, username, password); // Connection is a JDBC interface, con is a reference variable holding a Connection object, DriverManager is a class, and getConnection() is a static method that connects to PostgreSQL.

            System.out.println("PostgreSQL connected successfully!"); // System is a built-in class, out is a static PrintStream object, and println() is a method that prints text.

            Statement st = con.createStatement(); // Statement is a JDBC interface, st is a reference variable holding a Statement implementation object, and createStatement() is a method that creates an SQL statement.

            ResultSet rs = st.executeQuery(query); // ResultSet is a JDBC interface, rs is a reference variable holding a ResultSet implementation object, and executeQuery() executes a SELECT query and returns the result.

            if (rs.next()) { // 'if' is a keyword, next() is a ResultSet method that moves the cursor to the next row and returns true if a row exists.

                String chaiName = rs.getString("chai_name"); // String is a class, chaiName is a local reference variable, and getString() retrieves the chai_name column value from the current row.

                System.out.println("Chai Name: " + chaiName); // println() prints the message, and '+' joins the text with the chaiName value.

            } else { // 'else' is a keyword that runs when the if condition is false.

                System.out.println("No chai found!"); // Prints this message if the query returns no rows.

            } // Ends the if-else block.

            rs.close(); // Calls the ResultSet interface's close() method to release result-set resources.

            st.close(); // Calls the Statement interface's close() method to release statement resources.

            con.close(); // Calls the Connection interface's close() method to close the database connection.

            System.out.println("PostgreSQL connection CLOSED!"); // Prints a message after the connection has been closed.

        } catch (ClassNotFoundException | SQLException e) { // catch handles exceptions; ClassNotFoundException and SQLException are exception classes, '|' means either exception type, and e is the exception reference variable.

            e.printStackTrace(); // Calls a method on the exception object to print error details and the stack trace for debugging.

        } // Ends the catch block.

    } // Ends the main() method.

} // Ends the DemoJdbc class.
