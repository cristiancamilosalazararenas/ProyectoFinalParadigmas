package autonoma.proyectofinal.models;

import java.sql.SQLException;

public class Paciente {
    
    public Paciente(){
    }
    
    public Integer insertarPacienteBD(String nombre, String apellido, int edad) throws SQLException{
        PacienteDAO pacienteDAO = new PacienteDAO();
        return pacienteDAO.insertarPaciente(nombre, apellido, edad);
    }
}