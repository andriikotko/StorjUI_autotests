package pages;

import java.sql.*;

public class ConnectionToPostgres {
    public ConnectionToPostgres() {
    }

    public void connectionToPostgres(String sqlQuerry, String columnLabel) {
        Connection conn = null;
        try {// db parameters
            String url = "jdbc:postgresql://localhost/test123?sslmode=disable";
            // create a connection to the database
            conn = DriverManager.getConnection(url, "postgres", "postgres");

            System.out.println("Connection to postgresql has been established.");

            String schema = "satellite/0";

            Statement stmt = conn.createStatement();

            stmt.execute("set search_path to '" + schema + "'");

            System.out.println("done");

            ResultSet rs = stmt.executeQuery(sqlQuerry);

            while (rs.next()){
                String mail = rs.getString(columnLabel);
                System.out.println(mail);
            }
            //database_result = rs.getLong("amount");
           // database_result = rs.getLong(1);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
