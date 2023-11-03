
package com.mycompany.proyectojdbc;

import datos.PersonaDAO;
import domain.Persona;
import java.sql.SQLException;
import java.util.List;


public class Test {
    public static void main(String[] args) throws SQLException {
        
        Persona persona1 = new Persona("Juan","Pers","oiejoijdf","342345235235");
        
       
        PersonaDAO personadao = new PersonaDAO();
        
        personadao.insertar(persona1);
        
        List<Persona> personas = personadao.selecciona();
        
        personas.forEach(persona -> {
            System.out.println("persona = "+ persona);
            
            
        });
    }
}
