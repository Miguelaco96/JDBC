
package datos;

import domain.Persona;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PersonaDAO {
    
    private static final String SQL_SELECT = "SELECT id_persona, nombre, nombre, apellido, email, telefono FROM test.persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre,apellido,email,telefono) VALUES (?, ?, ?, ?)";
    
    public List<Persona> selecciona () throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona= null;
        
        List<Persona> personas = new ArrayList<>();
        
        conn = Conexion.getConnetion();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            
            int idPersona = rs.getInt("id_persona");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            persona = new Persona(idPersona, nombre, apellido, email, telefono);
            
            personas.add(persona);
        }
        
        
        rs.close();
        stmt.close();
        conn.close();
        
       return personas; 
    }
    
    public static void insertar(Persona persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
                      
        try {
            conn = Conexion.getConnetion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            
            int registros = stmt.executeUpdate();
            
                    
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }finally{
            stmt.close();
            conn.close();
            
        }
      
        
             
        
        
    }
}
