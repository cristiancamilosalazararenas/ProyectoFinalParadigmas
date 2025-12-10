/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package autonoma.proyectofinal.main;
import autonoma.proyectofinal.models.*;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import org.jpl7.Query;


/**
 *
 * @author camil
 */
public class main {

public static void main(String[] args) {
//        String rules = "consult('proyecto.pl')";
//       
//        Query q = new Query(rules);
//
//        if (q.hasSolution()) {
//            System.out.println("Archivo Prolog cargado correctamente.");
//        }
//        FactsBuilder.construirFactsOrganismo();
//        List<Organismo> lista = PrologQueryExecutor.getAnimals("organismo(Id, jaguar, Especie)");
//        for(Organismo o : lista){
//            System.out.println("Nombre: " + o.getId());
//            System.out.println("Nombre: " + o.getNombre());
//            System.out.println("Nombre: " + o.getEspecie());
//        }      
//        List<Depredacion> depredaciones = PrologQueryExecutor.getDepredaciones("depreda(Depredador, Presa).");
//        for(Depredacion d : depredaciones){
//            System.out.println("Depredador: " + d.getDepredador());
//            System.out.println("Presa: " + d.getPresa());
//        }   

          EnfermedadDAO dao = new EnfermedadDAO();
          try {
              List<Enfermedad> enfermedades = dao.buscarTodos() ;
              for(Enfermedad e : enfermedades){
                  System.out.println(e.getNombreEnfermedad());
                  System.out.println(e.getNombreCategoria());
                  System.out.println(e.getRecomendacionBasica());
                  System.out.println("##############################");
                  for(String e2 : e.getListaSintomas()){
                      System.out.println(e2);
                  }
                  System.out.println("##############################");
              }
        } catch (SQLException ex) {
            System.getLogger(main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }
}
