package autonoma.proyectofinal.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class PacienteDAO {
    private Connection conn;

    public PacienteDAO() {
        this.conn = MySQLConnection.getInstance().getConnection();
    }

    public Integer insertarPaciente(String nombre, String apellido, int edad) throws SQLException {
        String sql = "INSERT INTO pacientes (nombre_paciente, apellido, edad) VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setInt(3, edad);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                // Obtener el ID generado
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1); // Retorna el ID generado
                }
            }
            return null; // Si no se insertó nada

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ignored) {
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ignored) {
                    System.out.println("Error closing Prepared Statement");
                }
            }
        }
    }
}