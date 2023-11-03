
package datos;

import java.sql.*;

/**
 *
 * @author tester
 */
public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublickKeyRetrieval=true";
    private static final String JDBC_USER ="root";
    private static final String JDBC_PASS= "admin";
    
    public static Connection getConnetion() throws SQLException{
        
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
        
    }
    public static void closes(ResultSet rs) throws SQLException{
         rs.close();
    }
    public static void closes(PreparedStatement smtm) throws SQLException{
         smtm.close();
    }
    public static void closes(Connection conn) throws SQLException{
         conn.close();
    }     

    
    
}
