package autonoma.proyectofinal.models;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author camil
 */
public class FactsBuilder {
    private Connection conn;
    
    public FactsBuilder(){
        this.conn = MySQLConnection.getInstance().getConnection();
    }
    
    public static boolean construirFactsOrganismo(){
        EnfermedadDAO dao = new EnfermedadDAO();
        try{
            List<Enfermedad> lista = dao.buscarTodos();
            
            for(Enfermedad t : lista){
                StringBuilder sb = new StringBuilder();
                sb.append("assertz(enfermedad(")
                        //.append(t.getId()).append(",")
                        .append(t.getNombreEnfermedad()).append(", sintomas([")
                        .append(t.getListaSintomas()).append("]), categoria(")
                        .append(t.getNombreCategoria()).append("), recomendaciones(")
                        .append(t.getRecomendacionBasica()).append(")).");
                PrologQueryExecutor.createDynamicFact(sb.toString());
            }
        }catch(SQLException e){
            System.out.println("Error retrieving data");
        }
        return true;
    }   
}
