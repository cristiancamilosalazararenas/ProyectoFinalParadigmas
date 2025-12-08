/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectofinal.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camil
 */
public class EnfermedadDAO {
    private Connection conn;   // <–– the connection stays here as an attribute

    public EnfermedadDAO() {
        this.conn = MySQLConnection.getInstance().getConnection();
    }

    public List<Enfermedad> buscarTodos() throws SQLException {
        String sql = "SELECT id, nombre, especie FROM organismo";
        List<Enfermedad> lista = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(mapRow(rs));
            }
        } finally {
            if (rs != null) {
                try {
                    rs.close(); 
                } catch (SQLException ignored) {
                    System.out.println("Error closing result set");
                }
            }
                
            if (ps != null){
                try {
                    ps.close(); 
                } catch (SQLException ignored) {
                    System.out.println("Error closing prepared statement");
                }
            }
        }

        return lista;
    }
    
    
    private Enfermedad mapRow(ResultSet rs) throws SQLException {
        Enfermedad e = new Enfermedad();
        e.setId(rs.getInt("id"));
        e.setNombreEnfermedad(rs.getString(""));
        e.set(rs.getString("especie"));
        return e;
    }   
}
