package autonoma.proyectofinal.main;
import autonoma.proyectofinal.models.*;
import java.util.List;
import org.jpl7.Query;

public class main {

public static void main(String[] args) {
        String rules = "consult('proyecto.pl')";
       
        Query q = new Query(rules);

        if (q.hasSolution()) {
            System.out.println("Archivo Prolog cargado correctamente.");
        }
        FactsBuilder.construirFactsOrganismo();
        List<Enfermedad> lista = PrologQueryExecutor.getSolutions("enfermedad(Nombre,sintomas(Sintomas),categoria(Categoria),recomendaciones(Recomendaciones))");
        for(Enfermedad e : lista){
            System.out.println("Nombre: " + e.getNombreEnfermedad());
            System.out.println("Sintomas: " + e.getListaSintomas());
            System.out.println("Categoria: " + e.getNombreCategoria());
            System.out.println("Recomendaciones: " + e.getRecomendacionBasica());
        } 
    }
}