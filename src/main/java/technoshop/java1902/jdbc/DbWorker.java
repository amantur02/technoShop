package technoshop.java1902.jdbc;

import java.sql.*;

public class DbWorker {
    private final String url = "jdbc:postgresql://localhost:8081/postgres";
    private final String user = "postgres";
    private final String password = "bambuchok1902Am";

    public Connection connect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("Connected to the PostgreQSL server successfully.");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public int getUserCount(){
        String SQL = "SELECT count(*) FROM users";
        int count = 0;

        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL)){
            rs.next();
            count = rs.getInt(1);
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return count;
    }
}
